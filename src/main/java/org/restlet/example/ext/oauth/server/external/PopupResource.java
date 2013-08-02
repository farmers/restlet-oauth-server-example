package org.restlet.example.ext.oauth.server.external;

import java.util.logging.Level;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.CookieSetting;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.ext.freemarker.ContextTemplateLoader;
import org.restlet.ext.freemarker.TemplateRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.restlet.util.Series;
import com.google.gson.Gson;
import freemarker.template.Configuration;

public class PopupResource extends ServerResource {

  public static final String REDIRECT_URL = "http://localhost:8080/sample/popup";

  @Get("text/html")
  public Representation get() {

    String code = getQueryValue("code");
    String content = null;
    try {
      ClientResource cr = new ClientResource("http://localhost:8080/oauth/token");

      cr.setChallengeResponse(ChallengeScheme.HTTP_BASIC, ExternalApplication.clientID,
          ExternalApplication.clientSecret);

      Form form = new Form();
      form.add("client_id", ExternalApplication.clientID);
      form.add("client_secret", ExternalApplication.clientSecret);
      form.add("grant_type", "authorization_code");
      form.add("redirect_uri", REDIRECT_URL);
      form.add("code", code);
      String params = form.encode();

      getLogger().log(Level.INFO, "/oauth/token encoded query: " + params);

      Representation rep = cr.post(form, MediaType.APPLICATION_WWW_FORM);

      content = rep.getText();
      getLogger().log(Level.INFO, content);
    }
    catch (Exception e) {
      getLogger().log(Level.WARNING, "Failed to get access_token: " + e.getMessage(), e);
      content = "";
    }

    Gson gson = new Gson();
    TokenModel token = gson.fromJson(content, TokenModel.class);

    getLogger().log(Level.INFO, "response: " + content);

    if (token != null) {
      Series<CookieSetting> cs = getResponse().getCookieSettings();
      cs.add(0, new CookieSetting("token_type", token.getTokenType()));
      cs.add(1, new CookieSetting("access_token", token.getAccessToken()));
      cs.add(2, new CookieSetting("refresh_token", token.getRefreshToken()));
      setStatus(Status.SUCCESS_OK);
    }

    Configuration config = new Configuration();
    config.setTemplateLoader(new ContextTemplateLoader(getContext(), "clap://system/external/"));
    TemplateRepresentation rep =
        new TemplateRepresentation("popup.html", config, MediaType.TEXT_HTML);
    return rep;
  }
}
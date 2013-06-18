package br.brainshare.controller;

import java.io.IOException;
import java.io.Serializable;
import java.security.AuthProvider;
import java.util.Map;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.brickred.socialauth.Profile;
import org.brickred.socialauth.SocialAuthConfig;
import org.brickred.socialauth.SocialAuthManager;
import org.brickred.socialauth.util.SocialAuthUtil;

@ManagedBean(name = "userSession")
@SessionScoped
public class UserSessionBean implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String FACEBOOK_APP_ID = "210436739108415";
	private static final String FACEBOOK_APP_SECRET = "9e5688d06fb79635516761dfc7983604";
	
	private SocialAuthManager manager;
    private String            originalURL;
    private String            providerID;
    private Profile           profile;
    private String contexto;
    
	public UserSessionBean() {  }
    
    public void socialConnect() throws Exception {
        // Put your keys and secrets from the providers here 
        Properties props = System.getProperties();
        props.put("graph.facebook.com.consumer_key", FACEBOOK_APP_ID);
        props.put("graph.facebook.com.consumer_secret", FACEBOOK_APP_SECRET);
        // Define your custom permission if needed
        props.put("graph.facebook.com.custom_permissions", "publish_stream,email,user_birthday,user_location,offline_access");
        
        // Initiate required components
        SocialAuthConfig config = SocialAuthConfig.getDefault();
        config.load(props);
        manager = new SocialAuthManager();
        manager.setSocialAuthConfig(config);
        
        // 'successURL' is the page you'll be redirected to on successful login
        String successURL = "http://localhost:8080/BrainShare/pages/socialLoginSuccess.jsf"; 
        String authenticationURL = manager.getAuthenticationUrl(providerID, successURL);
        FacesContext.getCurrentInstance().getExternalContext().redirect(authenticationURL);
    }
    
    
    public String getContexto() {
        try {
            // Pull user's data from the provider
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
            Map<String, String> map = SocialAuthUtil.getRequestParametersMap(request);
            if (this.manager != null) {
                org.brickred.socialauth.AuthProvider provider = manager.connect(map);
                this.profile = provider.getUserProfile();
                System.out.println("User's Social profile: " + profile);
                // Do what you want with the data (e.g. persist to the database, etc.)
                return ("User's Social profile: " + profile);
            
                // Redirect the user back to where they have been before logging in
                //FacesContext.getCurrentInstance().getExternalContext().redirect(originalURL);
            
            } else return "Não entrou no if.. manage = null";
        } catch (Exception ex) {
            System.out.println("UserSession - Exception: " + ex.toString());
        }
		return "deu em nada!!"; 
    }
    
    public void logOut() {
        try {
            // Disconnect from the provider
            manager.disconnectProvider(providerID);
            
            // Invalidate session
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.invalidateSession();
            
            // Redirect to home page
            FacesContext.getCurrentInstance().getExternalContext().redirect(externalContext.getRequestContextPath() + "/");
        } catch (IOException ex) {
            System.out.println("UserSessionBean - IOException: " + ex.toString());
        }
    }
    
    public SocialAuthManager getManager() {
		return manager;
	}

	public void setManager(SocialAuthManager manager) {
		this.manager = manager;
	}

	public String getOriginalURL() {
		return originalURL;
	}

	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}

	public String getProviderID() {
		return providerID;
	}

	public void setProviderID(String providerID) {
		this.providerID = providerID;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
package web.prog.client;

import web.prog.shared.LoginVerifier;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWT_POS implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Button loginButton = new Button("Login");
		final TextBox usernameField = new TextBox();
		final PasswordTextBox passwordField = new PasswordTextBox();
		final Label errorLabel = new Label();
		
		final Button logoutButton = new Button("Logout");
		logoutButton.setWidth("188px");
		
		passwordField.setWidth("176px");
		passwordField.setHeight("18px");
		loginButton.setWidth("188px");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("usernameFieldContainer").add(usernameField);
		RootPanel.get("passwordFieldContainer").add(passwordField);
		RootPanel.get("loginButtonContainer").add(loginButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);
		RootPanel.get("logoutButtonContainer").add(logoutButton);

		// Focus the cursor on the name field when the app loads
		usernameField.setFocus(true);
		logoutButton.setVisible(false);

		// Create a handler for the loginButton
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the loginButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

		    /**
			 * Fired when the user types in the usernameField.
			 */
			public void onKeyUp(KeyUpEvent event) {}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String username = usernameField.getText();
				String password = passwordField.getText();
				if (!LoginVerifier.areCredentialsGood(username, password)) {
					errorLabel.setText("The username and/or password is not correct");
					return;
				}
				else{
					Document.get().getElementById("loginPage").getStyle().setVisibility(Visibility.HIDDEN);
					logoutButton.setVisible(true);
				}

				// Then, we send the input to the server.
				loginButton.setEnabled(false);

			}
			
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		loginButton.addClickHandler(handler);
		usernameField.addKeyUpHandler(handler);
	}
}

package web.prog.client;

import web.prog.shared.LoginVerifier;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWT_POS implements EntryPoint {

	final Button loginButton = new Button("Login");
	final TextBox usernameField = new TextBox();
	final PasswordTextBox passwordField = new PasswordTextBox();
	final Label errorLabel = new Label();
	final Button logoutButton = new Button("Logout");
	
	final Button createInvButton = new Button("Create Inventory Item");
	final Button deleteInvButton = new Button("Delete Inventory Item");
	final Button editInvButton = new Button("Edit Inventory Item");
	final Button createCustRecButton = new Button("Create Customer Record");
	final Button createPOSTranButton = new Button("Create POS Transaction");
	final Button listTranButton = new Button("List Transactions");
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		logoutButton.setWidth("188px");
		passwordField.setWidth("176px");
		passwordField.setHeight("18px");
		loginButton.setWidth("188px");

		// Add login information to Root Panel
		RootPanel.get("usernameField").add(usernameField);
		RootPanel.get("passwordField").add(passwordField);
		RootPanel.get("loginButton").add(loginButton);
		RootPanel.get("errorLabel").add(errorLabel);
		RootPanel.get("logoutButton").add(logoutButton);
		
		// Add menu information to Root Panel
		RootPanel.get("createInvButton").add(createInvButton);
		RootPanel.get("deleteInvButton").add(deleteInvButton);
		RootPanel.get("editInvButton").add(editInvButton);
		RootPanel.get("createCustRecButton").add(createCustRecButton);
		RootPanel.get("createPOSTranButton").add(createPOSTranButton);
		RootPanel.get("listTranButton").add(listTranButton);

		// Focus the cursor on the name field when the app loads
		usernameField.setFocus(true);
		logoutButton.setVisible(false);
		setMenuVisible(false);
		
		// Create a handler for the loginButton
		class LoginHandler implements ClickHandler {
			/**
			 * Fired when the user clicks on the loginButton.
			 */
			public void onClick(ClickEvent event) {
				login();
			}

			/**
			 * Send the name from the nameField to the server and wait for a
			 * response.
			 */
			private void login() {

				// First, we validate the input.
				errorLabel.setText("");
				String username = usernameField.getText();
				String password = passwordField.getText();
				if (!LoginVerifier.areCredentialsGood(username, password)) {
					errorLabel
							.setText("The username and/or password is not correct");
					return;
				} else {
					hideAll();
					setLoginVisible(false);
					loginButton.setEnabled(false);
					logoutButton.setVisible(true);
					setMenuVisible(true);
				}				
			}

		}
		// Add a handler to send the name to the server
		LoginHandler loginHandler = new LoginHandler();
		loginButton.addClickHandler(loginHandler);

		// Create a handler for the logoutButton
		class LogoutHandler implements ClickHandler {

			public void onClick(ClickEvent event) {
				logout();
			}

			private void logout() {
				hideAll();
				setLoginVisible(true);
				setMenuVisible(false);
				loginButton.setEnabled(true);
			}
		}

		LogoutHandler logoutHandler = new LogoutHandler();
		logoutButton.addClickHandler(logoutHandler);
	}

	private void hideAll() {
		Document.get().getElementById("all").getStyle()
				.setVisibility(Visibility.HIDDEN);
	}

	private void setLoginVisible(Boolean visible) {
		if (visible == true) {
			Document.get().getElementById("loginPage").getStyle()
					.setVisibility(Visibility.VISIBLE);
		} else {
			Document.get().getElementById("loginPage").getStyle()
					.setVisibility(Visibility.HIDDEN);
		}
	}
	
	private void setMenuVisible(Boolean visible){
		if (visible == true) {
			Document.get().getElementById("menu").getStyle()
					.setVisibility(Visibility.VISIBLE);
		} else {
			Document.get().getElementById("menu").getStyle()
					.setVisibility(Visibility.HIDDEN);
		}
	}
}

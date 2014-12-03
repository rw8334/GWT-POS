package web.prog.client;

import web.prog.shared.LoginVerifier;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Display;
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

		usernameField.setText("username");
		passwordField.setText("password");

		createInvButton.setWidth("188px");
		deleteInvButton.setWidth("188px");
		editInvButton.setWidth("188px");
		createCustRecButton.setWidth("188px");
		createPOSTranButton.setWidth("188px");
		listTranButton.setWidth("188px");

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
		hideAll();

		setLoginVisible(true);
		setLogoutVisible(false);
		setMenuVisible(false);

		// Create a handler for the loginButton
		class LoginHandler implements ClickHandler {
			/**
			 * Fired when the user clicks on the loginButton.
			 */
			public void onClick(ClickEvent event) {
				errorLabel.setText("");
				String username = usernameField.getText();
				String password = passwordField.getText();
				if (!LoginVerifier.areCredentialsGood(username, password)) {
					errorLabel
							.setText("The username and/or password is not correct");
					return;
				} else {
					hideAll();
					setLogoutVisible(true);
					setMenuVisible(true);
				}
			}
		}

		// Add a handler to verify the username and password
		LoginHandler loginHandler = new LoginHandler();
		loginButton.addClickHandler(loginHandler);

		// Create a handler for the logoutButton
		class LogoutHandler implements ClickHandler {

			public void onClick(ClickEvent event) {
				hideAll();
				setLoginVisible(true);
				setMenuVisible(false);
				setLogoutVisible(false);
			}
		}

		// Add a handler to log the user out
		LogoutHandler logoutHandler = new LogoutHandler();
		logoutButton.addClickHandler(logoutHandler);

		class CreateInvButtonHandler implements ClickHandler {
			int count = 0;

			public void onClick(ClickEvent event) {
				count++;

				if (count % 2 == 1) {
					createInvButton.setVisible(true);
					Document.get().getElementById("deleteInvButton").getStyle().setDisplay(Display.NONE);
					Document.get().getElementById("editInvButton").getStyle().setDisplay(Display.NONE);
					Document.get().getElementById("createCustRecButton").getStyle().setDisplay(Display.NONE);
					Document.get().getElementById("createPOSTranButton").getStyle().setDisplay(Display.NONE);
					Document.get().getElementById("listTranButton").getStyle().setDisplay(Display.NONE);
				} else {
					createInvButton.setVisible(true);
					Document.get().getElementById("deleteInvButton").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("editInvButton").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("createCustRecButton").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("createPOSTranButton").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("listTranButton").getStyle().setDisplay(Display.BLOCK);
				}
			}
		}

		// Add a handler to the Create Inventory Button
		CreateInvButtonHandler createInvButtonHandler = new CreateInvButtonHandler();
		createInvButton.addClickHandler(createInvButtonHandler);
	}

	private void hideAll() {
		Document.get().getElementById("login").getStyle()
				.setVisibility(Visibility.HIDDEN);

		Document.get().getElementById("menu").getStyle()
				.setVisibility(Visibility.HIDDEN);

		Document.get().getElementById("logout").getStyle()
				.setVisibility(Visibility.HIDDEN);
	}

	private void setLoginVisible(Boolean visible) {
		if (visible == true) {
			Document.get().getElementById("login").getStyle()
					.setVisibility(Visibility.VISIBLE);
		} else if (visible == false) {
			Document.get().getElementById("login").getStyle()
					.setVisibility(Visibility.HIDDEN);
		}
	}

	private void setMenuVisible(Boolean visible) {
		if (visible == true) {
			Document.get().getElementById("menu").getStyle()
					.setVisibility(Visibility.VISIBLE);
		} else if (visible == false) {
			Document.get().getElementById("menu").getStyle()
					.setVisibility(Visibility.HIDDEN);
		}
	}

	private void setLogoutVisible(Boolean visible) {
		if (visible == true) {
			Document.get().getElementById("logout").getStyle()
					.setVisibility(Visibility.VISIBLE);
		} else if (visible == false) {
			Document.get().getElementById("logout").getStyle()
					.setVisibility(Visibility.HIDDEN);
		}
	}
}

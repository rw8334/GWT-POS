package web.prog.client;

import web.prog.shared.LoginVerifier;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

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

	final TextBox descriptionField = new TextBox();
	final TextBox skuField = new TextBox();
	final TextBox pictureField = new TextBox();
	final TextBox priceField = new TextBox();
	final TextBox inventoryField = new TextBox();
	final Button createInvSubmitButton = new Button("Submit");

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		hideAll();
		Document.get().getElementById("sub1").getStyle()
				.setDisplay(Display.NONE);
		Document.get().getElementById("sub2").getStyle()
				.setDisplay(Display.NONE);
		Document.get().getElementById("sub3").getStyle()
				.setDisplay(Display.NONE);
		Document.get().getElementById("sub4").getStyle()
				.setDisplay(Display.NONE);
		Document.get().getElementById("sub5").getStyle()
				.setDisplay(Display.NONE);
		Document.get().getElementById("sub6").getStyle()
				.setDisplay(Display.NONE);

		setLoginVisible(true);
		setLogoutVisible(false);
		setMenuVisible(false);

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

		// Add sub menu information to Root Panel
		RootPanel.get("descriptionField").add(descriptionField);
		RootPanel.get("skuField").add(skuField);
		RootPanel.get("pictureField").add(pictureField);
		RootPanel.get("priceField").add(priceField);
		RootPanel.get("inventoryField").add(inventoryField);
		RootPanel.get("createInvSubmitButton").add(createInvSubmitButton);

		// Focus the cursor on the name field when the app loads
		usernameField.setFocus(true);

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
			int createInvCount = 0;

			public void onClick(ClickEvent event) {
				createInvCount++;

				createInvButton.setVisible(true);
				Document.get().getElementById("createInvButton").getStyle()
						.setDisplay(Display.BLOCK);

				if (createInvCount % 2 == 1) {
					Document.get().getElementById("sub1").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("sub2").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("sub3").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("sub4").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("sub5").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("sub6").getStyle()
							.setDisplay(Display.BLOCK);

					Document.get().getElementById("deleteInvButton").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("editInvButton").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("createCustRecButton")
							.getStyle().setDisplay(Display.NONE);
					Document.get().getElementById("createPOSTranButton")
							.getStyle().setDisplay(Display.NONE);
					Document.get().getElementById("listTranButton").getStyle()
							.setDisplay(Display.NONE);
				} else {
					Document.get().getElementById("sub1").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("sub2").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("sub3").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("sub4").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("sub5").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("sub6").getStyle()
							.setDisplay(Display.NONE);

					Document.get().getElementById("deleteInvButton").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("editInvButton").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("createCustRecButton")
							.getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("createPOSTranButton")
							.getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("listTranButton").getStyle()
							.setDisplay(Display.BLOCK);
				}
			}
		}

		// Add a handler to the Create Inventory Button
		CreateInvButtonHandler createInvButtonHandler = new CreateInvButtonHandler();
		createInvButton.addClickHandler(createInvButtonHandler);

		class DeleteInvButtonHandler implements ClickHandler {
			int deleteInvCount = 0;

			public void onClick(ClickEvent event) {
				deleteInvCount++;

				deleteInvButton.setVisible(true);
				Document.get().getElementById("deleteInvButton").getStyle()
						.setDisplay(Display.BLOCK);

				if (deleteInvCount % 2 == 1) {
					Document.get().getElementById("createInvButton").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("editInvButton").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("createCustRecButton")
							.getStyle().setDisplay(Display.NONE);
					Document.get().getElementById("createPOSTranButton")
							.getStyle().setDisplay(Display.NONE);
					Document.get().getElementById("listTranButton").getStyle()
							.setDisplay(Display.NONE);

				} else {
					Document.get().getElementById("createInvButton").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("editInvButton").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("createCustRecButton")
							.getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("createPOSTranButton")
							.getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("listTranButton").getStyle()
							.setDisplay(Display.BLOCK);
				}
			}
		}

		// Add a handler to the Delete Inventory Button
		DeleteInvButtonHandler deleteInvButtonHandler = new DeleteInvButtonHandler();
		deleteInvButton.addClickHandler(deleteInvButtonHandler);

		class EditInvButtonHandler implements ClickHandler {
			int editInvCount = 0;

			public void onClick(ClickEvent event) {
				editInvCount++;

				editInvButton.setVisible(true);
				Document.get().getElementById("editInvButton").getStyle()
						.setDisplay(Display.BLOCK);

				if (editInvCount % 2 == 1) {
					Document.get().getElementById("createInvButton").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("deleteInvButton").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("createCustRecButton")
							.getStyle().setDisplay(Display.NONE);
					Document.get().getElementById("createPOSTranButton")
							.getStyle().setDisplay(Display.NONE);
					Document.get().getElementById("listTranButton").getStyle()
							.setDisplay(Display.NONE);
				} else {
					Document.get().getElementById("createInvButton").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("deleteInvButton").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("createCustRecButton")
							.getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("createPOSTranButton")
							.getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("listTranButton").getStyle()
							.setDisplay(Display.BLOCK);
				}
			}
		}

		// Add a handler to the Edit Inventory Button
		EditInvButtonHandler editInvButtonHandler = new EditInvButtonHandler();
		editInvButton.addClickHandler(editInvButtonHandler);

		class CreateCustRecButtonHandler implements ClickHandler {
			int createCustCount = 0;

			public void onClick(ClickEvent event) {
				createCustCount++;

				createCustRecButton.setVisible(true);
				Document.get().getElementById("createCustRecButton").getStyle()
						.setDisplay(Display.BLOCK);

				if (createCustCount % 2 == 1) {
					Document.get().getElementById("createInvButton").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("deleteInvButton").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("editInvButton").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("createPOSTranButton")
							.getStyle().setDisplay(Display.NONE);
					Document.get().getElementById("listTranButton").getStyle()
							.setDisplay(Display.NONE);
				} else {
					Document.get().getElementById("createInvButton").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("deleteInvButton").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("editInvButton").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("createPOSTranButton")
							.getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("listTranButton").getStyle()
							.setDisplay(Display.BLOCK);
				}
			}
		}

		// Add a handler to the Create Customer Record Button
		CreateCustRecButtonHandler createCustRecButtonHandler = new CreateCustRecButtonHandler();
		createCustRecButton.addClickHandler(createCustRecButtonHandler);

		class CreatePOSTranButtonHandler implements ClickHandler {
			int createPOSCount = 0;

			public void onClick(ClickEvent event) {
				createPOSCount++;

				createPOSTranButton.setVisible(true);
				Document.get().getElementById("createPOSTranButton").getStyle()
						.setDisplay(Display.BLOCK);

				if (createPOSCount % 2 == 1) {
					Document.get().getElementById("createInvButton").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("deleteInvButton").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("editInvButton").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("createCustRecButton")
							.getStyle().setDisplay(Display.NONE);
					Document.get().getElementById("listTranButton").getStyle()
							.setDisplay(Display.NONE);
				} else {
					Document.get().getElementById("createInvButton").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("deleteInvButton").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("editInvButton").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("createCustRecButton")
							.getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("listTranButton").getStyle()
							.setDisplay(Display.BLOCK);
				}
			}
		}

		// Add a handler to the Create POS Transaction Button
		CreatePOSTranButtonHandler createPOSTranButtonHandler = new CreatePOSTranButtonHandler();
		createPOSTranButton.addClickHandler(createPOSTranButtonHandler);

		class ListTranButtonHandler implements ClickHandler {
			int listTranCount = 0;

			public void onClick(ClickEvent event) {
				listTranCount++;

				listTranButton.setVisible(true);
				Document.get().getElementById("listTranButton").getStyle()
						.setDisplay(Display.BLOCK);

				if (listTranCount % 2 == 1) {
					Document.get().getElementById("createInvButton").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("deleteInvButton").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("editInvButton").getStyle()
							.setDisplay(Display.NONE);
					Document.get().getElementById("createCustRecButton")
							.getStyle().setDisplay(Display.NONE);
					Document.get().getElementById("createPOSTranButton")
							.getStyle().setDisplay(Display.NONE);
				} else {
					Document.get().getElementById("createInvButton").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("deleteInvButton").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("editInvButton").getStyle()
							.setDisplay(Display.BLOCK);
					Document.get().getElementById("createCustRecButton")
							.getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("createPOSTranButton")
							.getStyle().setDisplay(Display.BLOCK);
				}
			}
		}

		// Add a handler to the List Transactions Button
		ListTranButtonHandler listTranButtonHandler = new ListTranButtonHandler();
		listTranButton.addClickHandler(listTranButtonHandler);

		class CreateInvSubmitButtonHandler implements ClickHandler {

			public void onClick(ClickEvent event) {

				final String description = descriptionField.getText();
				final String sku = skuField.getText();
				final String pictureLink = pictureField.getText();
				final String price = priceField.getText();
				final String inv = inventoryField.getText();

				class MyDialog extends DialogBox {

					public MyDialog() {
						setText("New Inventory Item");
						setAnimationEnabled(true);

						setGlassEnabled(true);

						Button ok = new Button("OK");
						ok.addClickHandler(new ClickHandler() {
							public void onClick(ClickEvent event) {
								MyDialog.this.hide();
							}
						});

						Label label1 = new Label("Description: " + description);
						Label label2 = new Label("SKU: " + sku);
						Label label3 = new Label("Picture Link: " + pictureLink);
						Label label4 = new Label("Price: " + price);
						Label label5 = new Label("Number of Items: " + inv);

						VerticalPanel panel = new VerticalPanel();
						panel.setHeight("100");
						panel.setWidth("300");
						panel.setSpacing(10);
						panel.add(label1);
						panel.add(label2);
						panel.add(label3);
						panel.add(label4);
						panel.add(label5);
						panel.add(ok);

						setWidget(panel);
					}
				}
				
				MyDialog myDialog = new MyDialog();
				int left = Window.getClientWidth() / 2;
				int top = Window.getClientHeight() / 2;
				myDialog.setPopupPosition(left, top);
				myDialog.show();
				
				descriptionField.setText("");
				skuField.setText("");
				pictureField.setText("");
				priceField.setText("");
				inventoryField.setText("");
			}

		}

		CreateInvSubmitButtonHandler createInvSubmitButtonHandler = new CreateInvSubmitButtonHandler();
		createInvSubmitButton.addClickHandler(createInvSubmitButtonHandler);
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
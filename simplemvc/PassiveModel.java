/**
 * This program demonstrates the use of Model View Controller pattern - Passive Model
 * @author  Essa Imhmed
 * Sep 26, 2023
 *
 */

 import java.util.Scanner;

 class Model {
	 private String message;
	 Controller controller;
 
	 /**
	  * Constructor
	  * @param message
	  */
	 public Model(Controller controller, String message) {
		 this.controller = controller;
		 this.message = message;
	 }
 
	 /**
	  * A function to set the controller
	  * @param controller
	  * @return
	  */
	 public void setController(Controller controller) {
		 this.controller = controller;
 
	 }
 
	 /**
	  * A function invoked by the controller to update the storage
	  * @param message
	  * @return
	  */
	 public void update(String message) {
		 this.message = message;
		 notify(message);
	 }
 
	 /**
	  * A function to notify the view by the update through the Controller
	  * @param message
	  */
	 private void notify(String message) {
		 controller.notify(message);
	 }
 }
 
 class Controller {
 
	 private Model model;
	 private View view;
 
	 /**
	  * Constructor
	  * @param model
	  * @param view
	  */
	 public Controller(Model model, View view) {
		 this.model = model;
		 this.view = view;
	 }
 
	 /**
	  * A function invoked by the view to request updating the storage
	  * in the module
	  * @param message
	  */
	 public void update(String message) {
		 model.update(message);
	 }
 
	 /**
	  * A function to notify the view about a successfull update
	  * @param message
	  */
	 public void notify(String message) {
		 updateView("Your message (" + message + ") has been successfully delivered.");
	 }
 
	 /**
	  * A function to pass a message to the view
	  * @param message
	  */
	 private void updateView(String message) {
		 view.update(message);
	 }
 
 }
 
 interface UserInterface {
	 /**
	  * send a request update to the model
	  * @param message
	  */
	 void update(String message);
 
	 /**
	  * Set the controller
	  * @param controller
	  */
	 void setController(Controller controller);
 
	 /**
	  * Pass a message to the controller to deliver it to the model
	  */
	 void sendMessage();
 }
 
 class View implements UserInterface {
 
	 private String name;
	 private Controller controller;
 
	 /**
	  * Constructor
	  * @param controller
	  * @param name
	  */
	 public View(Controller controller, String name) {
		 this.controller = controller;
		 this.name = name;
	 }
 
	 @Override
	 public void setController(Controller controller) {
		 this.controller = controller;
	 }
 
	 @Override
	 public void update(String message) {
		 System.out.println(name + " : " + message);
	 }
 
	 @Override
	 public void sendMessage() {
		 Scanner in = new Scanner(System.in);
		 System.out.println("Enter Text : ");
		 while ( in .hasNextLine()) {
			 String line = in .nextLine();
			 controller.update(line);
			 System.out.println("Enter Text : ");
		 } in .close();
	 }
 }
 
 public class PassiveModel {
 
	 public static void main(String[] args) {
 
		 Controller controller = null;
		 Model model = null;
		 View view = null;
 
		 model = new Model(null, "");
		 view = new View(null, "View 1");
 
		 controller = new Controller(model, view);
 
		 model.setController(controller);
		 view.setController(controller);
		 view.sendMessage();
	 }
 }
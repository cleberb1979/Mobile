package commons.actions;

import commons.start.LocalVariables;

public class SetValues {
	public static void setValores(LocalVariables lv, String nameElement, String attribute, 
			String valueAttribute, String valueField, String action, String message) {
		
		lv.setRobotElement(nameElement);
		lv.setRobotAtributte(attribute);
		lv.setRobotValueAttribute(valueAttribute);
		lv.setRobotValueField(valueField);
		lv.setRobotAction(action);
		lv.setRobotMessage(message);
		
	}

}

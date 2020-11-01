package commons.actions;

import commons.start.LocalVariables;

public class DefineAction {
	public static void defineAction(LocalVariables lv) {
		lv.setActionType(lv.getRobotAction());
		lv.setIndentifiedType(lv.getRobotAtributte());
	}

}

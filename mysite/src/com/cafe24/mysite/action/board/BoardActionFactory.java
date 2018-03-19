package com.cafe24.mysite.action.board;

import com.cafe24.mvc.action.AbstractActionFactory;
import com.cafe24.mvc.action.Action;

public class BoardActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {

		Action action = null;
		
		if ( "delete".equals( actionName ) ) {
			  
			action = new DeleteAction();
			
		} else if ( "write".equals( actionName ) ) {
		    
			action = new WriteActionForm();
			
		}	else if ( "add".equals( actionName ) ) {
		    
			action = new AddAction();
			
		}  else if ("view".equals(actionName)) {
			
			action = new ViewAction();
			
		} else if ("modify".equals(actionName)) {
			
			action = new ModifyAction();
			
		} else if ("modifyform".equals(actionName)) {
			
			action = new ModifyActionForm();
			
		}else if ("reply".equals(actionName)) {
			
			action = new ReplyAction();
			
		}
		else {
		    action = new ListAction();
		    
		}

		return action;
	    }

}

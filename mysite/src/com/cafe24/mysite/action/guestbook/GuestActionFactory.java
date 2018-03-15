package com.cafe24.mysite.action.guestbook;

import com.cafe24.mvc.action.AbstractActionFactory;
import com.cafe24.mvc.action.Action;
import com.cafe24.mysite.action.main.IndexAction;
import com.cafe24.mysite.action.user.JoinFormAction;

public class GuestActionFactory extends AbstractActionFactory {

    @Override
    public Action getAction( String actionName ) {
	Action action = null;

	if ( "add".equals( actionName ) ) {
	    action = new AddAction();
	} else if ( "deleteform".equals( actionName ) ) {
	    action = new DeleteFormAction();
	} else if ( "delete".equals( actionName ) ) {
	    action = new DeleteAction();
	} else {
	    action = new ListAction();
	}

	return action;
    }

}
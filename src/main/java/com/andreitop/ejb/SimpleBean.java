package com.andreitop.ejb;

import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.RemoveException;
import java.rmi.RemoteException;

public class SimpleBean implements EntityBean {

    public void setEntityContext(EntityContext entityContext) throws EJBException, RemoteException {

    }

    public void unsetEntityContext() throws EJBException, RemoteException {

    }

    public void ejbRemove() throws RemoveException, EJBException, RemoteException {

    }

    public void ejbActivate() throws EJBException, RemoteException {

    }

    public void helloFromBean() {
        System.out.println("Hello!");
    }

    public void ejbPassivate() throws EJBException, RemoteException {

    }

    public void ejbLoad() throws EJBException, RemoteException {

    }

    public void ejbStore() throws EJBException, RemoteException {

    }

}




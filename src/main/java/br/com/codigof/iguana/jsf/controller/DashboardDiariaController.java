package br.com.codigof.iguana.jsf.controller;

import br.com.codigof.iguana.jpa.entities.DashboardDiaria;
import br.com.codigof.iguana.jsf.controller.util.JsfUtil;
import br.com.codigof.iguana.jsf.controller.util.PaginationHelper;
import br.com.codigof.iguana.beans.DashboardDiariaFacade;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ResourceBundle;
import javafx.scene.control.TablePosition;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("dashboardDiariaController")
@SessionScoped
public class DashboardDiariaController implements Serializable {

    private DashboardDiaria current;
    private DataModel items = null;
    @EJB
    private br.com.codigof.iguana.beans.DashboardDiariaFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public DashboardDiariaController() {
    }

    public DashboardDiaria getSelected() {
        if (current == null) {
            current = new DashboardDiaria();
            selectedItemIndex = -1;
        }
        return current;
    }

    private DashboardDiariaFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (DashboardDiaria) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new DashboardDiaria();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DashboardDiariaCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (DashboardDiaria) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DashboardDiariaUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (DashboardDiaria) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DashboardDiariaDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public DashboardDiaria getDashboardDiaria(java.math.BigInteger id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = DashboardDiaria.class)
    public static class DashboardDiariaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DashboardDiariaController controller = (DashboardDiariaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "dashboardDiariaController");
            return controller.getDashboardDiaria(getKey(value));
        }

//        java.math.BigInteger getKey(String value) {
//            java.math.BigInteger key;
//            key = java.math.BigInteger.valueOf(value);
//            return key;
//        }

        String getStringKey(java.math.BigInteger value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof DashboardDiaria) {
                DashboardDiaria o = (DashboardDiaria) object;
                return getStringKey(o.getQtdAtdAbertos());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + DashboardDiaria.class.getName());
            }
        }

        private BigInteger getKey(String value) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
    
    
    public void dashboardUpdater(){
//        current = ejbFacade.find(getSelected().getAtendimentosabertos());
        if(current != null){
            current = ejbFacade.findAll().get(0);
//            System.out.println("Atendimentos em espera: " + current.getAtendimentoemspera());
        }
//        else{
//            System.out.println("Current iniciou como nulo.");
//        }
//        System.out.println("Passou por aqui");
    }

}

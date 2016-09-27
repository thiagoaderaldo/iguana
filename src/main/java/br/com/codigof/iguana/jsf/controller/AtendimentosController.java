package br.com.codigof.iguana.jsf.controller;

import br.com.codigof.iguana.jpa.entities.Atendimentos;
import br.com.codigof.iguana.jsf.controller.util.JsfUtil;
import br.com.codigof.iguana.jsf.controller.util.PaginationHelper;
import br.com.codigof.iguana.beans.AtendimentosFacade;
import br.com.codigof.iguana.beans.SolicitacoesFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
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

@Named("atendimentosController")
@SessionScoped
public class AtendimentosController implements Serializable {

    private Atendimentos current;
    private DataModel items = null;
    @EJB
    private br.com.codigof.iguana.beans.AtendimentosFacade ejbFacade;
    @EJB
    private br.com.codigof.iguana.beans.SolicitacoesFacade solicitacoesEjbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public AtendimentosController() {
    }

    public Atendimentos getSelected() {
        if (current == null) {
            current = new Atendimentos();
            selectedItemIndex = -1;
        }
        return current;
    }

    private AtendimentosFacade getFacade() {
        return ejbFacade;
    }

    public SolicitacoesFacade getSolicitacoesEjbFacade() {
        return solicitacoesEjbFacade;
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
        current = (Atendimentos) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
//        return "View";
        return null;
    }

    public String prepareCreate() {
        current = new Atendimentos();
        selectedItemIndex = -1;
        return "Create";
    }
    
    public String linkCreate() {
        current = new Atendimentos();
        selectedItemIndex = -1;
        return "/admin/atendimentos/Create";
    }

    public String create() {
        try {
//            current.setIdSolicitacao(solicitacoesEjbFacade.find(current.getIdSolicitacao().getProtocolo()));
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AtendimentosCreated"));
            return prepareCreate();
        } catch (Exception e) {
            System.out.println("Mensagem de erro: " + e.getMessage());
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));

            return null;
        }
    }

    public String prepareEdit() {
        current = (Atendimentos) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
//        return "Edit";
        return null;
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AtendimentosUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Atendimentos) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AtendimentosDeleted"));
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

    public Atendimentos getAtendimentos(java.lang.Long id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Atendimentos.class)
    public static class AtendimentosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AtendimentosController controller = (AtendimentosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "atendimentosController");
            return controller.getAtendimentos(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Atendimentos) {
                Atendimentos o = (Atendimentos) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Atendimentos.class.getName());
            }
        }

    }

}

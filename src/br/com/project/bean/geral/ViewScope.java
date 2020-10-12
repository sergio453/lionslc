package br.com.project.bean.geral;

import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.web.context.request.FacesRequestAttributes;

public class ViewScope implements Scope {
	
	public static final String VIEW_SCOPE_CALLBACKS = "viewScope.callBacks";

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		Object instance = getViewMap().get(name);
		if (instance == null) {
			instance = objectFactory.getObject();
			getViewMap().put(name, instance);
		}
		return instance;
	}

	@Override
	public String getConversationId() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesRequestAttributes facesRequestAttributes = new FacesRequestAttributes(facesContext);		
		return facesRequestAttributes.getSessionId() + "-" + facesContext.getViewRoot().getViewId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void registerDestructionCallback(String name, Runnable runnable	) {
		Map<String, Runnable> callbacks = (Map<String, Runnable>) getViewMap().get(VIEW_SCOPE_CALLBACKS);
		if(callbacks != null) {
			callbacks.put(VIEW_SCOPE_CALLBACKS, runnable);			
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object remove(String name) {
		Object instance = getViewMap().remove(name);
		if (instance != null) {
			Map<String, Runnable> callBacks = (Map<String, Runnable>) getViewMap().get(VIEW_SCOPE_CALLBACKS);
			if(callBacks != null){
				callBacks.remove(name);
			}
		}
		return instance;
	}

	@Override
	public Object resolveContextualObject(String name) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesRequestAttributes facesRequestAttributes = new FacesRequestAttributes(facesContext);
		return facesRequestAttributes.resolveReference(name);
	}

	/**
	 * getViewRoot() retorna o componente raiz que está associado a esta
	 * solicitação(request). getViewMap() retorna um mapa que é uma lista com um
	 * código e um valor que atua na interface para armazenamento de dados...
	 * 
	 * @return
	 */
	private Map<String, Object> getViewMap() {
		return FacesContext.getCurrentInstance() != null ? FacesContext.getCurrentInstance().getViewRoot().getViewMap()
				: new HashMap<String, Object>();
	}

}

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.odcgroup.page.metamodel.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import com.odcgroup.page.metamodel.util.MetaModelAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MetaModelItemProviderAdapterFactory extends MetaModelAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaModelItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.WidgetType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WidgetTypeItemProvider widgetTypeItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.WidgetType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWidgetTypeAdapter() {
		if (widgetTypeItemProvider == null) {
			widgetTypeItemProvider = new WidgetTypeItemProvider(this);
		}

		return widgetTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.PropertyType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyTypeItemProvider propertyTypeItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.PropertyType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPropertyTypeAdapter() {
		if (propertyTypeItemProvider == null) {
			propertyTypeItemProvider = new PropertyTypeItemProvider(this);
		}

		return propertyTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.WidgetTemplate} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WidgetTemplateItemProvider widgetTemplateItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.WidgetTemplate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWidgetTemplateAdapter() {
		if (widgetTemplateItemProvider == null) {
			widgetTemplateItemProvider = new WidgetTemplateItemProvider(this);
		}

		return widgetTemplateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.AccountabilityRule} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccountabilityRuleItemProvider accountabilityRuleItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.AccountabilityRule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAccountabilityRuleAdapter() {
		if (accountabilityRuleItemProvider == null) {
			accountabilityRuleItemProvider = new AccountabilityRuleItemProvider(this);
		}

		return accountabilityRuleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.WidgetLibrary} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WidgetLibraryItemProvider widgetLibraryItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.WidgetLibrary}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWidgetLibraryAdapter() {
		if (widgetLibraryItemProvider == null) {
			widgetLibraryItemProvider = new WidgetLibraryItemProvider(this);
		}

		return widgetLibraryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.Accountability} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccountabilityItemProvider accountabilityItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.Accountability}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAccountabilityAdapter() {
		if (accountabilityItemProvider == null) {
			accountabilityItemProvider = new AccountabilityItemProvider(this);
		}

		return accountabilityItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.DataType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeItemProvider dataTypeItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.DataType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDataTypeAdapter() {
		if (dataTypeItemProvider == null) {
			dataTypeItemProvider = new DataTypeItemProvider(this);
		}

		return dataTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.DataValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataValueItemProvider dataValueItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.DataValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDataValueAdapter() {
		if (dataValueItemProvider == null) {
			dataValueItemProvider = new DataValueItemProvider(this);
		}

		return dataValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.MetaModel} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaModelItemProvider metaModelItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.MetaModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMetaModelAdapter() {
		if (metaModelItemProvider == null) {
			metaModelItemProvider = new MetaModelItemProvider(this);
		}

		return metaModelItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.PropertyTemplate} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyTemplateItemProvider propertyTemplateItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.PropertyTemplate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPropertyTemplateAdapter() {
		if (propertyTemplateItemProvider == null) {
			propertyTemplateItemProvider = new PropertyTemplateItemProvider(this);
		}

		return propertyTemplateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.DataTypes} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypesItemProvider dataTypesItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.DataTypes}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDataTypesAdapter() {
		if (dataTypesItemProvider == null) {
			dataTypesItemProvider = new DataTypesItemProvider(this);
		}

		return dataTypesItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.IncludeabilityRule} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IncludeabilityRuleItemProvider includeabilityRuleItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.IncludeabilityRule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIncludeabilityRuleAdapter() {
		if (includeabilityRuleItemProvider == null) {
			includeabilityRuleItemProvider = new IncludeabilityRuleItemProvider(this);
		}

		return includeabilityRuleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.EventModel} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventModelItemProvider eventModelItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.EventModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEventModelAdapter() {
		if (eventModelItemProvider == null) {
			eventModelItemProvider = new EventModelItemProvider(this);
		}

		return eventModelItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.WidgetEvent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WidgetEventItemProvider widgetEventItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.WidgetEvent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWidgetEventAdapter() {
		if (widgetEventItemProvider == null) {
			widgetEventItemProvider = new WidgetEventItemProvider(this);
		}

		return widgetEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.FunctionType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionTypeItemProvider functionTypeItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.FunctionType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFunctionTypeAdapter() {
		if (functionTypeItemProvider == null) {
			functionTypeItemProvider = new FunctionTypeItemProvider(this);
		}

		return functionTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.ParameterType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterTypeItemProvider parameterTypeItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.ParameterType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createParameterTypeAdapter() {
		if (parameterTypeItemProvider == null) {
			parameterTypeItemProvider = new ParameterTypeItemProvider(this);
		}

		return parameterTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.EventTemplate} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventTemplateItemProvider eventTemplateItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.EventTemplate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEventTemplateAdapter() {
		if (eventTemplateItemProvider == null) {
			eventTemplateItemProvider = new EventTemplateItemProvider(this);
		}

		return eventTemplateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.ParameterTemplate} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterTemplateItemProvider parameterTemplateItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.ParameterTemplate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createParameterTemplateAdapter() {
		if (parameterTemplateItemProvider == null) {
			parameterTemplateItemProvider = new ParameterTemplateItemProvider(this);
		}

		return parameterTemplateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.EventType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventTypeItemProvider eventTypeItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.EventType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEventTypeAdapter() {
		if (eventTypeItemProvider == null) {
			eventTypeItemProvider = new EventTypeItemProvider(this);
		}

		return eventTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.SnippetType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SnippetTypeItemProvider snippetTypeItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.SnippetType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSnippetTypeAdapter() {
		if (snippetTypeItemProvider == null) {
			snippetTypeItemProvider = new SnippetTypeItemProvider(this);
		}

		return snippetTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.SnippetModel} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SnippetModelItemProvider snippetModelItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.SnippetModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSnippetModelAdapter() {
		if (snippetModelItemProvider == null) {
			snippetModelItemProvider = new SnippetModelItemProvider(this);
		}

		return snippetModelItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.WidgetSnippet} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WidgetSnippetItemProvider widgetSnippetItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.WidgetSnippet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWidgetSnippetAdapter() {
		if (widgetSnippetItemProvider == null) {
			widgetSnippetItemProvider = new WidgetSnippetItemProvider(this);
		}

		return widgetSnippetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.odcgroup.page.metamodel.EventSnippet} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventSnippetItemProvider eventSnippetItemProvider;

	/**
	 * This creates an adapter for a {@link com.odcgroup.page.metamodel.EventSnippet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEventSnippetAdapter() {
		if (eventSnippetItemProvider == null) {
			eventSnippetItemProvider = new EventSnippetItemProvider(this);
		}

		return eventSnippetItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (widgetTypeItemProvider != null) widgetTypeItemProvider.dispose();
		if (propertyTypeItemProvider != null) propertyTypeItemProvider.dispose();
		if (metaModelItemProvider != null) metaModelItemProvider.dispose();
		if (widgetTemplateItemProvider != null) widgetTemplateItemProvider.dispose();
		if (accountabilityRuleItemProvider != null) accountabilityRuleItemProvider.dispose();
		if (widgetLibraryItemProvider != null) widgetLibraryItemProvider.dispose();
		if (accountabilityItemProvider != null) accountabilityItemProvider.dispose();
		if (dataTypeItemProvider != null) dataTypeItemProvider.dispose();
		if (dataValueItemProvider != null) dataValueItemProvider.dispose();
		if (propertyTemplateItemProvider != null) propertyTemplateItemProvider.dispose();
		if (dataTypesItemProvider != null) dataTypesItemProvider.dispose();
		if (includeabilityRuleItemProvider != null) includeabilityRuleItemProvider.dispose();
		if (eventModelItemProvider != null) eventModelItemProvider.dispose();
		if (widgetEventItemProvider != null) widgetEventItemProvider.dispose();
		if (functionTypeItemProvider != null) functionTypeItemProvider.dispose();
		if (parameterTypeItemProvider != null) parameterTypeItemProvider.dispose();
		if (eventTemplateItemProvider != null) eventTemplateItemProvider.dispose();
		if (parameterTemplateItemProvider != null) parameterTemplateItemProvider.dispose();
		if (eventTypeItemProvider != null) eventTypeItemProvider.dispose();
		if (snippetTypeItemProvider != null) snippetTypeItemProvider.dispose();
		if (snippetModelItemProvider != null) snippetModelItemProvider.dispose();
		if (widgetSnippetItemProvider != null) widgetSnippetItemProvider.dispose();
		if (eventSnippetItemProvider != null) eventSnippetItemProvider.dispose();
	}

}

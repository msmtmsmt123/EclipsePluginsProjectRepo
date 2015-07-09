/**
 */
package com.odcgroup.t24.menu.menu.impl;

import com.odcgroup.edge.t24ui.T24UIPackage;

import com.odcgroup.mdf.ecore.MdfPackage;

import com.odcgroup.t24.enquiry.enquiry.EnquiryPackage;

import com.odcgroup.t24.menu.menu.Enabled;
import com.odcgroup.t24.menu.menu.MenuFactory;
import com.odcgroup.t24.menu.menu.MenuItem;
import com.odcgroup.t24.menu.menu.MenuPackage;
import com.odcgroup.t24.menu.menu.MenuRoot;
import com.odcgroup.t24.menu.menu.Translation;

import com.odcgroup.t24.version.versionDSL.VersionDSLPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MenuPackageImpl extends EPackageImpl implements MenuPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass menuRootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass menuItemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass translationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum enabledEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see com.odcgroup.t24.menu.menu.MenuPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private MenuPackageImpl()
  {
    super(eNS_URI, MenuFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link MenuPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static MenuPackage init()
  {
    if (isInited) return (MenuPackage)EPackage.Registry.INSTANCE.getEPackage(MenuPackage.eNS_URI);

    // Obtain or create and register package
    MenuPackageImpl theMenuPackage = (MenuPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MenuPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MenuPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    T24UIPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theMenuPackage.createPackageContents();

    // Initialize created meta-data
    theMenuPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theMenuPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(MenuPackage.eNS_URI, theMenuPackage);
    return theMenuPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMenuRoot()
  {
    return menuRootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMenuRoot_MetamodelVersion()
  {
    return (EAttribute)menuRootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMenuRoot_RootItem()
  {
    return (EReference)menuRootEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMenuItem()
  {
    return menuItemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMenuItem_Name()
  {
    return (EAttribute)menuItemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMenuItem_Enabled()
  {
    return (EAttribute)menuItemEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMenuItem_DisplayTabs()
  {
    return (EAttribute)menuItemEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMenuItem_SecurityRole()
  {
    return (EAttribute)menuItemEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMenuItem_Shortcut()
  {
    return (EAttribute)menuItemEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMenuItem_Labels()
  {
    return (EReference)menuItemEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMenuItem_Version()
  {
    return (EReference)menuItemEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMenuItem_Enquiry()
  {
    return (EReference)menuItemEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMenuItem_CompositeScreen()
  {
    return (EReference)menuItemEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMenuItem_IncludedMenu()
  {
    return (EReference)menuItemEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMenuItem_Application()
  {
    return (EReference)menuItemEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMenuItem_Parameters()
  {
    return (EAttribute)menuItemEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMenuItem_Submenus()
  {
    return (EReference)menuItemEClass.getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTranslation()
  {
    return translationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTranslation_Language()
  {
    return (EAttribute)translationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTranslation_Message()
  {
    return (EAttribute)translationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getEnabled()
  {
    return enabledEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MenuFactory getMenuFactory()
  {
    return (MenuFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    menuRootEClass = createEClass(MENU_ROOT);
    createEAttribute(menuRootEClass, MENU_ROOT__METAMODEL_VERSION);
    createEReference(menuRootEClass, MENU_ROOT__ROOT_ITEM);

    menuItemEClass = createEClass(MENU_ITEM);
    createEAttribute(menuItemEClass, MENU_ITEM__NAME);
    createEAttribute(menuItemEClass, MENU_ITEM__ENABLED);
    createEAttribute(menuItemEClass, MENU_ITEM__DISPLAY_TABS);
    createEAttribute(menuItemEClass, MENU_ITEM__SECURITY_ROLE);
    createEAttribute(menuItemEClass, MENU_ITEM__SHORTCUT);
    createEReference(menuItemEClass, MENU_ITEM__LABELS);
    createEReference(menuItemEClass, MENU_ITEM__VERSION);
    createEReference(menuItemEClass, MENU_ITEM__ENQUIRY);
    createEReference(menuItemEClass, MENU_ITEM__COMPOSITE_SCREEN);
    createEReference(menuItemEClass, MENU_ITEM__INCLUDED_MENU);
    createEReference(menuItemEClass, MENU_ITEM__APPLICATION);
    createEAttribute(menuItemEClass, MENU_ITEM__PARAMETERS);
    createEReference(menuItemEClass, MENU_ITEM__SUBMENUS);

    translationEClass = createEClass(TRANSLATION);
    createEAttribute(translationEClass, TRANSLATION__LANGUAGE);
    createEAttribute(translationEClass, TRANSLATION__MESSAGE);

    // Create enums
    enabledEEnum = createEEnum(ENABLED);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    VersionDSLPackage theVersionDSLPackage = (VersionDSLPackage)EPackage.Registry.INSTANCE.getEPackage(VersionDSLPackage.eNS_URI);
    EnquiryPackage theEnquiryPackage = (EnquiryPackage)EPackage.Registry.INSTANCE.getEPackage(EnquiryPackage.eNS_URI);
    T24UIPackage theT24UIPackage = (T24UIPackage)EPackage.Registry.INSTANCE.getEPackage(T24UIPackage.eNS_URI);
    MdfPackage theMdfPackage = (MdfPackage)EPackage.Registry.INSTANCE.getEPackage(MdfPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(menuRootEClass, MenuRoot.class, "MenuRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMenuRoot_MetamodelVersion(), ecorePackage.getEString(), "metamodelVersion", null, 0, 1, MenuRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMenuRoot_RootItem(), this.getMenuItem(), null, "rootItem", null, 0, 1, MenuRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(menuItemEClass, MenuItem.class, "MenuItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMenuItem_Name(), ecorePackage.getEString(), "name", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMenuItem_Enabled(), this.getEnabled(), "enabled", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMenuItem_DisplayTabs(), ecorePackage.getEBoolean(), "displayTabs", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMenuItem_SecurityRole(), ecorePackage.getEString(), "securityRole", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMenuItem_Shortcut(), ecorePackage.getEString(), "shortcut", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMenuItem_Labels(), this.getTranslation(), null, "labels", null, 0, -1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMenuItem_Version(), theVersionDSLPackage.getVersion(), null, "version", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMenuItem_Enquiry(), theEnquiryPackage.getEnquiry(), null, "enquiry", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMenuItem_CompositeScreen(), theT24UIPackage.getCompositeScreen(), null, "compositeScreen", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMenuItem_IncludedMenu(), this.getMenuRoot(), null, "includedMenu", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMenuItem_Application(), theMdfPackage.getMdfClass(), null, "application", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMenuItem_Parameters(), ecorePackage.getEString(), "parameters", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMenuItem_Submenus(), this.getMenuItem(), null, "submenus", null, 0, -1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(translationEClass, Translation.class, "Translation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTranslation_Language(), ecorePackage.getEString(), "language", null, 0, 1, Translation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTranslation_Message(), ecorePackage.getEString(), "message", null, 0, 1, Translation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(enabledEEnum, Enabled.class, "Enabled");
    addEEnumLiteral(enabledEEnum, Enabled.TRUE);
    addEEnumLiteral(enabledEEnum, Enabled.FALSE);
    addEEnumLiteral(enabledEEnum, Enabled.CONDITIONAL);

    // Create resource
    createResource(eNS_URI);
  }

} //MenuPackageImpl

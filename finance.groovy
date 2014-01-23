import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;

ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
	WebKeys.THEME_DISPLAY);

companyId = themeDisplay.getCompanyId();

Group group = GroupLocalServiceUtil.getGroup(companyId, "Guest");

groupId = group.getGroupId();

userId = PortalUtil.getUserId(actionRequest);

ServiceContext serviceContext = ServiceContextFactory.getInstance(
	actionRequest);

serviceContext.setScopeGroupId(groupId);

// Finance

Layout financeLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, "Finance", "", "", "link_to_layout", false,
	"/finance", serviceContext);

// Currency Converter

Layout currencyConverterLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, financeLayout.getLayoutId(), "Currency Converter",
	"", "", "portlet", false, "/currency-converter", serviceContext);

LayoutTypePortlet currencyConverterLayoutTypePortlet =
	(LayoutTypePortlet)currencyConverterLayout.getLayoutType();

currencyConverterLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_FinanceSM001", "column-1", -1, false);
currencyConverterLayoutTypePortlet.addPortletId(
	userId, "16", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, currencyConverterLayout.getLayoutId(),
	currencyConverterLayout.getTypeSettings());

// Loan Calculator

Layout loanCalculatorLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, financeLayout.getLayoutId(), "Loan Calculator",
	"", "", "portlet", false, "/loan-calculator", serviceContext);

LayoutTypePortlet loanCalculatorLayoutTypePortlet =
	(LayoutTypePortlet)loanCalculatorLayout.getLayoutType();

loanCalculatorLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_FinanceSM002", "column-1", -1, false);
loanCalculatorLayoutTypePortlet.addPortletId(
	userId, "61", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, loanCalculatorLayout.getLayoutId(),
	loanCalculatorLayout.getTypeSettings());

// Link parent page with first child page

UnicodeProperties financeTypeSettingsProperties =
	financeLayout.getTypeSettingsProperties();

financeTypeSettingsProperties.setProperty(
	"linkToLayoutId", String.valueOf(currencyConverterLayout.getLayoutId()));

financeLayout.setTypeSettingsProperties(financeTypeSettingsProperties);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, financeLayout.getLayoutId(),
	financeLayout.getTypeSettings());
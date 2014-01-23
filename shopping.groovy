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
import com.liferay.portlet.shopping.model.ShoppingCategory;
import com.liferay.portlet.shopping.service.ShoppingCategoryLocalServiceUtil;
import com.liferay.portlet.shopping.service.ShoppingItemLocalServiceUtil;

ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
	WebKeys.THEME_DISPLAY);

companyId = themeDisplay.getCompanyId();

Group group = GroupLocalServiceUtil.getGroup(companyId, "Guest");

groupId = group.getGroupId();

userId = PortalUtil.getUserId(actionRequest);

ServiceContext serviceContext = ServiceContextFactory.getInstance(
	actionRequest);

serviceContext.setScopeGroupId(groupId);

// Shopping

Layout shoppingLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, "Shopping", "", "", "link_to_layout", false,
	"/shopping", serviceContext);

// Shopping

Layout shoppingPortletLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, shoppingLayout.getLayoutId(), "Shopping Portlet",
	"", "", "portlet", false, "/shopping-portlet", serviceContext);

LayoutTypePortlet shoppingPortletLayoutTypePortlet =
	(LayoutTypePortlet)shoppingPortletLayout.getLayoutType();

shoppingPortletLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ShoppingSM01", "column-1", -1, false);
shoppingPortletLayoutTypePortlet.addPortletId(
	userId, "34", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, shoppingPortletLayout.getLayoutId(),
	shoppingPortletLayout.getTypeSettings());

ShoppingCategory shoppingCategory =
	ShoppingCategoryLocalServiceUtil.addCategory(
		userId, 0, "Shopping Category Name", "Shopping categery description",
		serviceContext);

ShoppingItemLocalServiceUtil.addItem(
	userId, groupId, shoppingCategory.getCategoryId(), "ShoppingItemSKU",
	"Shopping Item Name", "Shopping item description",
	"Shopping item properties", "", false, 100, false, null, false, "", null,
	false, "", null, false, "", null, new ArrayList(), new ArrayList(),
	serviceContext);

// Amazon Rankings

Layout amazonRankingsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, shoppingLayout.getLayoutId(), "Amazon Rankings", "",
	"", "portlet", false, "/amazon-rankings", serviceContext);

LayoutTypePortlet amazonRankingsLayoutTypePortlet =
	(LayoutTypePortlet)amazonRankingsLayout.getLayoutType();

amazonRankingsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_ShoppingSM02", "column-1", -1, false);
amazonRankingsLayoutTypePortlet.addPortletId(
	userId, "67", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, amazonRankingsLayout.getLayoutId(),
	amazonRankingsLayout.getTypeSettings());

// Link parent page with first child page

UnicodeProperties shoppingTypeSettingsProperties =
	shoppingLayout.getTypeSettingsProperties();

shoppingTypeSettingsProperties.setProperty(
	"linkToLayoutId", String.valueOf(shoppingPortletLayout.getLayoutId()));

shoppingLayout.setTypeSettingsProperties(shoppingTypeSettingsProperties);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, shoppingLayout.getLayoutId(),
	shoppingLayout.getTypeSettings());
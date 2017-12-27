int count = 5;
SideMenu.MenuItem item = sideMenu.createMenuItem("count");
item.setCaption("Messages");
item.setBadgeText(count + " new");
item.setIconFromSet(CubaIcon.ENVELOPE);
sideMenu.addMenuItem(item,0);
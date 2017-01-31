public void updateCounters(Timer source) {
    sideMenu.getMenuItemNN("sales")
            .setBadgeText(String.valueOf(LocalTime.MIDNIGHT.minusSeconds(timerCounter-source.getDelay())));
    timerCounter++;
}
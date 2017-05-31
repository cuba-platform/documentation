table.addAction(new AddAction(table){
    @Override
    public Map<String, Object> getWindowParams(){
        return ParamsMap.of("customer",getItem());
    }
});
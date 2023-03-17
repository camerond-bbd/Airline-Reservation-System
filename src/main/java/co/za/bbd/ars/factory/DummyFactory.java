package co.za.bbd.ars.factory;

import co.za.bbd.ars.model.DummyDomain;

public class DummyFactory {

    public static DummyDomain createDummyDomain(String tableId, String tableColumn) {
        //TODO: Validation comes here

        //TODO: Check if groups wants to use builder pattern
//        return new DummyDomain.Builder()
//                .setTableId(tableId)
//                .setTableColumn(tableColumn)
//                .build();
        return null;
    }
}

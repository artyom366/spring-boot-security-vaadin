package ee.erp.central.user.layouts;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.shared.ui.table.CollapseMenuContent;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import java.util.Objects;

/**
 * Created by Artyom on 1/2/2016.
 */

@SpringComponent
@UIScope
public class UserLayout extends VerticalLayout {

    public UserLayout init() {

        setMargin(true);
        setSpacing(true);
        setSizeFull();

        Table table = new Table();
        table.addContainerProperty("c1", Integer.class, 1);
        table.addContainerProperty("c2", String.class, "2");
        table.addContainerProperty("c3", String.class, "3");
        table.addContainerProperty("c4", String.class, "4");

        table.setColumnHeaders("Number", "Name", "Surname", "Descriptions   ");

        for (int i = 0; i < 10; i++) {
            table.addItem(new Object[]{i, "name " + i, "surname " + i, "test " + i}, i);
        }

        table.setPageLength(0);
        table.setFooterVisible(true);

        table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent itemClickEvent) {

                Item item = itemClickEvent.getItem();

                Property property = itemClickEvent.getItem().getItemProperty("c1");
                String val = property.getValue().toString();

                Notification.show(item.toString() + "\n" + val);
            }
        });

        table.setColumnCollapsingAllowed(true);
        table.setColumnReorderingAllowed(true);

        table.addColumnReorderListener(new Table.ColumnReorderListener() {
            @Override
            public void columnReorder(Table.ColumnReorderEvent columnReorderEvent) {

                System.out.println(columnReorderEvent.getConnector());
                for (Object o  : table.getVisibleColumns()) {
                    System.out.println(o.toString());
                }

            }
        });

        table.addColumnCollapseListener(new Table.ColumnCollapseListener() {
            @Override
            public void columnCollapseStateChange(Table.ColumnCollapseEvent columnCollapseEvent) {

                System.out.println(columnCollapseEvent.getPropertyId());

            }
        });

        addComponent(table);

        return this;
    }
}

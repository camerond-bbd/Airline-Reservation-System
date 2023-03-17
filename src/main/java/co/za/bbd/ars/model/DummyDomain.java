package co.za.bbd.ars.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class DummyDomain {
        @NotNull
        @Id

        private String tableId;
        @NotNull
        private String tableColumn;

        protected DummyDomain() {}

//        private DummyDomain(Builder builder) {
//            this.tableId = builder.tableId;
//            this.tableColumn = builder.tableColumn;
//        }

        public String getTableId() {
            return tableId;
        }

        public String getTableColumn() {
            return tableColumn;
        }

        @Override
        public String toString() {
            return "DummyDomain{" +
                    "tableId=" + tableId +
                    ", tableColumn='" + tableColumn + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DummyDomain d = (DummyDomain) o;
            return tableId.equals(d.tableId) && tableColumn.equals(d.tableColumn);
        }

        @Override
        public int hashCode() {
            return Objects.hash(tableId, tableColumn);
        }
}

package co.za.bbd.ars.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Entity
public class TicketStatuses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statusId", nullable = false)
    private Integer statusId;

    @Column(name = "status", nullable = false)
    private String status;

    public TicketStatuses() {
    }

    public TicketStatuses(Integer statusId, String status) {
        this.statusId = statusId;
        this.status = status;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TicketStatuses)) return false;
        TicketStatuses that = (TicketStatuses) o;
        return Objects.equals(statusId, that.statusId) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusId, status);
    }

    @Override
    public String toString() {
        return "TicketStatuses{" +
                "statusId=" + statusId +
                ", status='" + status + '\'' +
                '}';
    }
}

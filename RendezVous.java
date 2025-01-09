package test_cabinet_medical;

import java.time.LocalDate;
import java.time.LocalTime;

public class RendezVous {
    private LocalDate date;
    private LocalTime heure;

    public RendezVous(LocalDate date, LocalTime heure) {
        this.date = date;
        this.heure = heure;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RendezVous that = (RendezVous) obj;
        return date.equals(that.date) && heure.equals(that.heure);
    }

    @Override
    public int hashCode() {
        return date.hashCode() * 31 + heure.hashCode();
    }
}


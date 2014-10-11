package ca.ulaval.glo4003.projet_de_session.web.viewmodels;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import ca.ulaval.glo4003.projet_de_session.core.domain.TempsParTache;

public class FeuilleDeTempsViewModel {
	
	public Long id;
	
	public String debutPeriode;
	
	public String finPeriode;
	
	public String employe;
	
	public ArrayList<TempsParTache> taches;
		
	
	public Long obtId() {
		return id;
	}

	public void defId(Long _id) {
		this.id = _id;
	}
	
	
	public String obtDebutPeriode() {
		return debutPeriode;
	}
	
	public void defDebutPeriode(String _debutPeriode){
		debutPeriode = _debutPeriode;
	}


	public String obtFinPeriode() {
		return finPeriode;
	}
	
	public void defFinPeriode(String _finPeriode){
		finPeriode = _finPeriode;
	}

	
	public String obtEmploye() {
		return employe;
	}

	public void defEmploye(String _employe) {
		this.employe = _employe;
	}
	
	
	public ArrayList<String> obtListeJoursPeriode(){
		ArrayList<String> dates = new ArrayList<String>();
		
		LocalDate debutPeriodeDateTime = new LocalDate(new DateTime(debutPeriode));
		LocalDate finPeriodeDateTime = new LocalDate(new DateTime(finPeriode));
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy");
		
		int days = Days.daysBetween(debutPeriodeDateTime, finPeriodeDateTime).getDays();
		for (int i=0; i < days; i++) {
		    LocalDate d = debutPeriodeDateTime.withFieldAdded(DurationFieldType.days(), i);
		    dates.add(formatter.print(d));
		}
		
		return dates;
	}
	
	
	public ArrayList<TempsParTache> obtTaches() {
		return taches;
	}

	public void defTaches(ArrayList<TempsParTache> _taches) {
		this.taches = _taches;
	}


}

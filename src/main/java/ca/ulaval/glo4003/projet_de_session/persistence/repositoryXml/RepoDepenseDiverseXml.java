
package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.RepoDepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.persistence.utils.Xml;

public class RepoDepenseDiverseXml implements RepoDepenseDiverse {
	
	ArrayList<DepenseDiverse> depensesDiverse;
	Xml<DepenseDiverse> xmlDepense;

	public RepoDepenseDiverseXml() {
		depensesDiverse = new ArrayList<DepenseDiverse>();
		xmlDepense = new Xml<DepenseDiverse>(DepenseDiverse.class);
		charger();
	}

	@Override
	public void ajouter(DepenseDiverse depense) {
		depensesDiverse.add(depense);
		sauvegarder();
	}

	@Override
	public DepenseDiverse obtenir(String identifiantDepense) {
		for (DepenseDiverse depenseDiverse : depensesDiverse) {
			if (depenseDiverse.obtIdentifant() == identifiantDepense)
				return depenseDiverse;
		}

		// TODO Lancer une exeption
		return null;
	}

	@Override
	public List<DepenseDiverse> obtTout() {
		return depensesDiverse;
	}

	@Override
	public void modifier(DepenseDiverse depense) {
		sauvegarder();
	}

	private void charger() {

	}

	private void sauvegarder() {
	xmlDepense.enregistrer(depensesDiverse, "xmlfiles/depenses");
	}
}

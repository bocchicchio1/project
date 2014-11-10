package ca.ulaval.glo4003.projet_de_session.core.utils.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.Depense;
import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDiverseViewModel;

public class DepenseDiverseConverter {

	public Collection<DepenseDiverseViewModel> convert(
			List<DepenseDiverse> depenses) {
		Collection<DepenseDiverseViewModel> viewModels = new ArrayList<DepenseDiverseViewModel>();
		for (Depense depense : depenses) {
			DepenseDiverseViewModel viewModel = convert((DepenseDiverse) depense);
			viewModels.add(viewModel);
		}
		return viewModels;
	}

	public DepenseDiverseViewModel convert(DepenseDiverse depense) {
		DepenseDiverseViewModel viewModel = new DepenseDiverseViewModel();
		viewModel.coucher = depense.obtCoucher();
		viewModel.coutRepas = depense.obtCoutRepas();
		viewModel.date = depense.getDate().toString();
		viewModel.description = depense.getDescription();
		viewModel.identifiant = depense.getIdentifiant();
		viewModel.nbRepas = depense.obtNbRepas();
		viewModel.divers = depense.obtDivers();

		return viewModel;
	}
	
	public DepenseDiverse convert(DepenseDiverseViewModel diverseViewModel) {
		DepenseDiverse diverse = new DepenseDiverse();
		diverse.defCoucher(diverseViewModel.coucher);
		diverse.defCoutRepas(diverseViewModel.coutRepas);
		diverse.setDate(diverseViewModel.date);
		diverse.setDescription(diverseViewModel.description);
		diverse.setIdentifiant(diverseViewModel.identifiant);
		diverse.defNbRepas(diverseViewModel.nbRepas);
		diverse.defDivers(diverseViewModel.divers);
		diverse.setTime(diverseViewModel.time);
		return diverse;
	}
}

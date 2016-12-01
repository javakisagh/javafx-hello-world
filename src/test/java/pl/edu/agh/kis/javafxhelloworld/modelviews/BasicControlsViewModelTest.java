package pl.edu.agh.kis.javafxhelloworld.modelviews;

import static org.junit.Assert.*;
import static org.hamcrest.collection.IsIn.*;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsArrayContaining.*;


import org.junit.Test;

public class BasicControlsViewModelTest {

	@Test
	public void afterButtonClickedTextEditItemIsInsertedIntoAvailableItemList() {
	  //setup:
		BasicControlsViewModel viewModel = new BasicControlsViewModel();
	  //when:
		viewModel.newItemTextChanged().setValue("newItem");
		viewModel.addNewItem().handle(null);
	  //then:
		assertThat(viewModel.allItems().getValue().toArray(),hasItemInArray("newItem"));
	}

}

package controller;

import java.io.IOException;
import java.util.ArrayList;

public class User {

	private boolean login = false;

	public boolean memberDisplay(view.Interface v_view, model.ToolSet m_toolSet) throws IOException {

		// reads from text files
		m_toolSet.populate();

		while (true) {

			boolean successful = true;

			//present instructions
			v_view.presentInstruction();
			if(v_view.getChoice() > 5  || login == true){
			v_view.displayInput1();
			}
			//choices
			if (v_view.getChoice() == 1 && login == true) {
				if (!m_toolSet.addMember(v_view.getInputValue1(),v_view.getInputValue2())) {

					successful = false;
				}

			} else if (v_view.getChoice() == 2 && login == true) {
				if (!m_toolSet.addBoat(v_view.getInputValue1(),Integer.parseInt(v_view.getInputValue2()),v_view.getInputValue3())) {

					successful = false;
				}

			} else if (v_view.getChoice() == 3 && login == true) {
				if (!m_toolSet.deleteMember(v_view.getInputValue1())) {

					successful = false;
				}

			} else if (v_view.getChoice() == 4 && login == true) {
				if (!m_toolSet.deleteBoat(v_view.getInputValue1(),v_view.getInputValue2())) {

					successful = false;
				}

			} else if (v_view.getChoice() == 5 && login == true) {
				if (!m_toolSet.changeBoat(v_view.getInputValue1(),v_view.getInputValue2(),v_view.getInputValue3())) {

					successful = false;
				}

			} else if (v_view.getChoice() == 6) {
				login = false;

			} else if (v_view.getChoice() == 7) {
				v_view.compactList(m_toolSet.getMemberStorage());

			} else if (v_view.getChoice() == 8) {
				v_view.verboseList(m_toolSet.getMemberStorage());

			} else if (v_view.getChoice() == 9) {
				search(v_view, m_toolSet);

			} else if (v_view.getChoice() == 10 && login == false) {
				if (m_toolSet.authenticate(v_view.getInputValue1(),v_view.getInputValue2())) {
					login = true;
				} else {
					successful = false;
				}

			} else if (v_view.getChoice() == 11) {
				v_view.exit();
				break;

			}
			//errors or successful
			if (login == false && v_view.getChoice() < 6) {
				v_view.errorLogin();
			}else if (successful == false) {
				v_view.error();
			} else {
				v_view.successful();
			}
			// wait to show the main instructions
			v_view.pressEnterToContinue();
		}
		v_view.closeScanner();
		return false;
	}

	public void search(view.Interface v_view, model.ToolSet m_toolSet) {

		ArrayList<String> choiceList = new ArrayList<String>();
		// choiceList is built like, {operator(&& or ||), search type, String to
		// be searched for}
		int temp;
		// first instance always the same
		choiceList.add("||");

		// loading inputs
		while (true) {
			choiceList.add(String.valueOf(v_view.getInputValue1()));
			choiceList.add(String.valueOf(v_view.getInputValue2()));

			// checks if you want to do nested search
			v_view.serchPlusOperator(choiceList);
			temp = Integer.parseInt(v_view.getInputValue3());
			if (temp == 3) {
				break;
			} else if (temp == 2) {
				choiceList.add("||");
			} else if (temp == 1) {
				choiceList.add("&&");
			}
			v_view.displayInput1();
		}
		v_view.verboseList(m_toolSet.search(choiceList));
	}

}

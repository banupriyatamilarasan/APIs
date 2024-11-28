package com.omrBranch.payload.address;

import com.omrBranch.pojo.stateList.AddUpdateUserAddress_Input_Pojo;
import com.omrBranch.pojo.stateList.AddUserAddress_Input_Pojo;
import com.omrBranch.pojo.stateList.CityList_Intput_Pojo;
import com.omrBranch.pojo.stateList.DeleteAddress_Input_Pojo;

	public class AddressPayload {

		public CityList_Intput_Pojo addCityPayload(String stateId) {
			CityList_Intput_Pojo cityList_Input_Pojo = new CityList_Intput_Pojo(stateId);
			return cityList_Input_Pojo;

		}

		public AddUserAddress_Input_Pojo addAddressPayload(String fistName, String lastName, String mobileNo,
				String apptName, String stateId, String cityId, String countryId, String zipCode, String address,
				String addressType) {
			AddUserAddress_Input_Pojo addUserAddress_Input_Pojo = new AddUserAddress_Input_Pojo(fistName, lastName,
					mobileNo, apptName, Integer.parseInt(stateId), Integer.parseInt(cityId), Integer.parseInt(countryId), zipCode, address, addressType);
			return addUserAddress_Input_Pojo;
		}

		public AddUpdateUserAddress_Input_Pojo updateAddressPayload(String addressId, String fistName, String lastName,
				String mobileNo, String apptName, String stateId, String cityId, String countryId, String zipCode, String address,
				String addressType) {
			AddUpdateUserAddress_Input_Pojo updateAddress_Input_Pojo = new AddUpdateUserAddress_Input_Pojo(addressId, fistName, lastName,
					mobileNo, apptName, Integer.parseInt(stateId), Integer.parseInt(cityId), Integer.parseInt(countryId), zipCode, address, addressType);
			return updateAddress_Input_Pojo;

		}

		public DeleteAddress_Input_Pojo deleteAddress(String addressId) {
			DeleteAddress_Input_Pojo deleteUserAddress_Input_Pojo = new DeleteAddress_Input_Pojo(addressId);
			return deleteUserAddress_Input_Pojo;

		}

	}



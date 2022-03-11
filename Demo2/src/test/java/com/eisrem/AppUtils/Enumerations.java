package com.eisrem.AppUtils;

import java.math.BigInteger;

public class Enumerations {

	/*			TYPES			*/
	public enum AppModule {
		SELECT ("SELECT", "Select", 0),
		//PLANNING ("PLANNING",1),
		ASSESSMENT ("ASSESSMENT", "Assessment", 1),
		NOTES ("NOTES", "Notes", 2),
		REPORTABLE_EVENT ("REPORTABLE_EVENT", "Reportable Event", 3);

		private final String module;   
		private final String moduleAllCaps; 
		private final int index;
		

		private AppModule(String moduleAllCaps, String module, int index) {
			this.moduleAllCaps = moduleAllCaps;
			this.module = module;
			this.index = index;
		}

		public int getIndex() {
			return this.index;
		}

		public String getNameAllCaps() {
			return this.moduleAllCaps;
		}
		
		public String getName() {
			return this.module;
		}
	}

	public enum LockTime {
		SELECT ("Select",0, new BigInteger("0")),
		NEVER ("NEVER",1, new BigInteger("1000002591")),
		IMMEDIATELY ("IMMEDIATELY",2, new BigInteger("1000002592")),
		HOURS_24 ("24 HOURS",3, new BigInteger("1000002593")),
		HOURS_48 ("48 HOURS",4, new BigInteger("1000002594")),
		WEEK_1 ("1 WEEK",5, new BigInteger("1000002595")),
		MONTH_1 ("1 MONTH",6, new BigInteger("1000002596")),
		YEAR_1 ("1 YEAR",7, new BigInteger("1000002597"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private LockTime(String lockTime, int index, BigInteger id) {
			this.name = lockTime;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	public enum AppAreaConductType {
		SELECT ("Select",0, new BigInteger("0")),
		ORGANIZATION ("ORGANIZATION",1, new BigInteger("1000004434")),
		PEOPLE ("PEOPLE",2, new BigInteger("1000004435")),
		BOTH ("BOTH",3, new BigInteger("1000004436"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private AppAreaConductType(String appAreaConductType, int index, BigInteger id) {
			this.name = appAreaConductType;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	/*			TYPE CONDUCTED ON			*/		
	public enum ConductTypeOn {
		ORGANIZATION ("ORGANIZATION",1),
		LOCATION ("LOCATION",2),
		PEOPLE ("PEOPLE",3);

		private final String name;    
		private final int index;

		private ConductTypeOn(String appAreaConductType, int index) {
			this.name = appAreaConductType;
			this.index = index;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}
	}

	/*			ROLES			*/		
	public enum Roles {
		SELECT ("Select...",0, new BigInteger("0")),
		ADD_CLIENT_ROLE ("ADD CLIENT ROLE",1, new BigInteger("1000001128")),
		ALLAPPS ("ALLAPPS",2, new BigInteger("1")),
		CBH_PROVIDER_APPLICATION_ROLE ("CBH PROVIDER APPLICATION ROLE",3, new BigInteger("1000001068")),
		CS_ADMIN_ROLE ("CS ADMIN ROLE",4, new BigInteger("1000000252")),
		CS_PROVIDER_ROLE ("CS PROVIDER ROLE",5, new BigInteger("1000000039")),
		CS_STATE_PROVIDER ("CS STATE ROLE",6, new BigInteger("1000000031")),
		CS_VIEW_ONLY ("CS VIEW ONLY",7, new BigInteger("1000001088")),
		DOC_TEST ("CS VIEW ONLY",8, new BigInteger("1000001268")),
		DTX_VIEW_ONLY_ROLE ("DTX VIEW ONLY ROLE",9, new BigInteger("1000000808")),
		DTXC_CASE_MANAGER ("DTXC CASE MANAGER",10, new BigInteger("1000000748")),
		PNMI_PROVIDER_DATA_INPUT_ROLE ("PNMI PROVIDER DATA INPUT ROLE",11, new BigInteger("1000000828")),
		SA_PROGRAM_ADMINISTRATOR ("SA PROGRAM ADMINISTRATOR",12, new BigInteger("1000000549")),
		SAHMS_ADMIN_ROLE ("SAHMS ADMIN ROLE",13, new BigInteger("1000000408")),
		SAMHS_STATE_ROLE ("SAHMS STATE ROLE",14, new BigInteger("1000000908")),
		SELENIUM_PROVIDER_ROLE ("SELENIUM PROVIDER ROLE",15, new BigInteger("1000001188")),
		SELENIUM_STATE_ROLE ("SELENIUM STATE ROLE",16, new BigInteger("1000001189")),
		SOC_ROLE ("SOC ROLE",17, new BigInteger("1000001168")),
		SYSTEM_ADMIN ("SYSTEM ADMIN",18, new BigInteger("1000000928")),
		SYSTEM_ADMIN_VIEW_ONLY ("SYSTEM ADMIN VIEW ONLY",19, new BigInteger("1000001148"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private Roles(String role, int index, BigInteger id) {
			this.name = role;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	/*			SERVICE POPULATIONS			*/			
	public enum ServicePopulations {
		NULL ("NULL",-1, new BigInteger("0")),
		SELECT ("Select...",0, new BigInteger("0")),
		ADULT_MH ("ADULT MH",1, new BigInteger("577308")),
		AMHI_CONSENT_DECREE ("AMHI CONSENT DECREE",2, new BigInteger("577311")),
		CHILDRENS ("CHILDRENS",3, new BigInteger("577310")),
		SUBSTANCE_USE ("SUBSTANCE USE",4, new BigInteger("1000000068"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private ServicePopulations(String servicePopulation, int index, BigInteger id) {
			this.name = servicePopulation;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	/*			NOTIFICATIONS			*/	
	public enum NotificationFormat {
		SELECT ("Select",0, new BigInteger("10000021319")),
		EQUALS ("=",1, new BigInteger("1000002131")),
		LESS_THEN ("<",2, new BigInteger("1000002132")),
		GREATER_THEN (">",3, new BigInteger("1000002133")),
		NOT_EQUAL ("!=",4, new BigInteger("1000002134")),
		LESS_THEN_OR_EQUAL ("<=",5, new BigInteger("1000002141")),
		GREATER_THEN_OR_EQUAL (">=",6, new BigInteger("1000002140")),
		CONTAINS ("CONTAINS (TEXT AREA/NARRATIVE)",7, new BigInteger("1000002144")),
		IS_EDITED ("TYPE/ANSWER IS EDITED",8, new BigInteger("1000002139")),
		IS_ENTERED ("TYPE/ANSWER IS ENTERED",9, new BigInteger("1000002145")),
		IS_RELATED ("IS RELATED TO ANOTHER CONDUCTED TYPE ID",10, new BigInteger("1000002135")),
		WAS_EDITED ("TYPE/ANSWER WAS EDITED",11, new BigInteger("1000002137")),
		WAS_ENTERED ("TYPE/ANSWER WAS ENTERED",12, new BigInteger("1000002138")),
		ANSWER_IS_SELECTED ("ANSWER IS SELECTED",13, new BigInteger("1000002138")),
		ANSWER_DATE_VALUE_IS ("ANSWER DATE VALUE IS",14, new BigInteger("1000002138")),
		ANSWER_LOOKUP_VALUE_IS ("ANSWER LOOKUP VALUE IS",15, new BigInteger("1000002138")),
		;

		private final String name;    
		private final int index;
		private BigInteger id;

		private NotificationFormat(String notificationFormat, int index, BigInteger id) {
			this.name = notificationFormat;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getName() {
			return this.name;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	public enum NotificationWhenFormat {
		SELECT ("Select",0, new BigInteger("0")),
		MINUTES ("MINUTES",1, new BigInteger("1000002151")),
		HOURS ("HOURS",2, new BigInteger("1000002152")),
		DAYS ("DAYS",3, new BigInteger("1000002153")),
		WEEKS ("WEEKS",4, new BigInteger("1000002149")),
		MONTHS ("MONTHS",5, new BigInteger("1000002154")),
		YEARS ("YEARS",6, new BigInteger("1000002150"));

		private final String name;    
		private final int index;
		private BigInteger id;

		private NotificationWhenFormat(String format, int index, BigInteger id) {
			this.name = format;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	public enum NotificationWhenOccurance {
		SELECT ("Select",0, new BigInteger("0")),
		UPON_SUBMISSION ("UPON SUBMISSION",3, new BigInteger("1000002148")),
		WAS_ENTERED ("TYPE WAS PREVIOUSLY ENTERED",2, new BigInteger("1000002147")),
		WAS_EDITED ("TYPE WAS PREVIOUSLY EDITED",1, new BigInteger("1000002146"));

		private final String name;    
		private final int index;
		private BigInteger id;

		private NotificationWhenOccurance(String occurance, int index, BigInteger id) {
			this.name = occurance;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	public enum NotificationMessageType {
		SELECT("Select",0, new BigInteger("0")),
		TEXT ("TEXT",1, new BigInteger("1000002166")),
		ATTRIBUTE ("ATTRIBUTE",2, new BigInteger("1000002167"));

		private final String name;    
		private final int index;
		private BigInteger id;

		private NotificationMessageType(String messageType, int index, BigInteger id) {
			this.name = messageType;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	public enum NotificationMessageAttribute {
		SELECT("Select",0, new BigInteger("0")),
		PEOPLE_ID ("PEOPLE_ID",1, new BigInteger("1000002162")),
		TYPE_ID ("TYPE_ID",2, new BigInteger("1000002163")),
		USER_ID ("USER_ID",3, new BigInteger("1000002164")),
		TYPE_NAME ("TYPE_NAME",4, new BigInteger("1000002165")),
		DATE ("DATE",5, new BigInteger("1000002160")),
		TIME ("TIME",6, new BigInteger("1000002161")),
		ORG_NAME ("ORG_NAME",7, new BigInteger("1000004335")),
		ORG_ID ("ORG_ID",8, new BigInteger("1000004317"));

		private final String name;    
		private final int index;
		private BigInteger id;

		private NotificationMessageAttribute(String messageAttribute, int index, BigInteger id) {
			this.name = messageAttribute;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	public enum NotificationWhoType {
		SELECT("Select",0, new BigInteger("0")),
		USER ("USER",1, new BigInteger("1000002155")),
		ROLE ("ROLE",2, new BigInteger("1000002156")),
		SERVICE_POPULATION ("SERVICE_POPULATION",3, new BigInteger("1000002157")),
		CREATOR ("CREATOR",4, new BigInteger("1000002158")),
		SUBMITTER ("SUBMITTER",5, new BigInteger("1000002159"));

		private final String name;    
		private final int index;
		private BigInteger id;

		private NotificationWhoType(String whoType, int index, BigInteger id) {
			this.name = whoType;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	/*			PAGES			*/			
	public enum QuestionType {
		SELECT("Select",0, new BigInteger("0")),
		CHECK_BOX ("CHECK BOX",1, new BigInteger("8133")),
		CHOICE_BOX ("CHOICE BOX",2, new BigInteger("8135")),
		DATE_FIELD ("DATE FIELD",3, new BigInteger("8358")),
		DECIMAL_FIELD ("DECIMAL FIELD",4, new BigInteger("8137")),
		FIELD ("FIELD",5, new BigInteger("6037")),
		INTEGER_FIELD ("INTEGER FIELD",6, new BigInteger("8138")),
		LIST_BOX ("LIST BOX (MULTI SELECT)",7, new BigInteger("8136")),
		ORGANIZATION_LOOKUP ("ORGANIZATION LOOKUP",8, new BigInteger("13231")),
		PERSON_LOOKUP ("PERSON LOOKUP",9, new BigInteger("13232")),
		TIME_FIELD ("TIME FIELD",10, new BigInteger("579548")),
		RADIO_BUTTON ("RADIO BUTTON",11, new BigInteger("8134")),
		TEXT_AREA ("TEXT AREA (4000 VARCHARACTERS)",12, new BigInteger("8132")),
		TEXT_FIELD ("TEXT FIELD (80 VARCHARACTERS)",13, new BigInteger("8131")),
		USER_LOOKUP ("USER LOOKUP",14, new BigInteger("579568")),
		EMAIL ("EMAIL",15, new BigInteger("8368")),
		PHONE_NUMBER ("PHONE NUMBER",16, new BigInteger("8378")),
		CONDUCTED_TYPE_SEARCH ("CNDCTD TYPE SEARCH",17, new BigInteger("13233")),
		SCORE ("SCORE",18, new BigInteger("1000004897")),
		PRINCIPLE_SCORE ("PRINCIPLE SCORE",19, new BigInteger("1000004898")),
		DOCUMENT_LOOKUP ("DOCUMENT LOOKUP",20, new BigInteger("1000005022"))
		;

		private final String name;    
		private final int index;
		private BigInteger id;

		private QuestionType(String questionType, int index, BigInteger id) {
			this.name = questionType;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	/*			SEARCH			*/	
	public enum SearchFor {
		USER ("USER",1, new BigInteger("1000003081")),
		CONDUCTED_TYPE ("CONDUCTED TYPE",2, new BigInteger("1000003082")),
		LOCATION ("LOCATION",3, new BigInteger("1000003083")),
		ORGANIZATION ("ORGANIZATION",4, new BigInteger("1000003084"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private SearchFor(String searchFor, int index, BigInteger id) {
			this.name = searchFor;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	public enum SearchBy {
		SELECT ("SELECT",0, new BigInteger("0")),
		ID ("ID",1, new BigInteger("1000003074")),
		DATE_RANGE ("DATE RANGE",2, new BigInteger("1000003075")),
		IDENTIFIER ("IDENTIFIER",3, new BigInteger("1000003076")),
		SUBMIT_DATE ("SUBMIT DATE",4, new BigInteger("1000004094")),
		ADDRESS ("ADDRESS",5, new BigInteger("1000003077")),
		USERNAME ("USERNAME",6, new BigInteger("1000003078")),
		BASE_LOCATION ("BASE LOCATION",7, new BigInteger("1000003080")),
		NAME ("NAME",8, new BigInteger("1000003079"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private SearchBy(String searchFor, int index, BigInteger id) {
			this.name = searchFor;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	public enum SearchCondition {
		SELECT ("SELECT",0, new BigInteger("0")),
		AND ("AND",1, new BigInteger("1000003085")),
		OR ("OR",2, new BigInteger("1000003086"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private SearchCondition(String searchFor, int index, BigInteger id) {
			this.name = searchFor;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}

	}

	public enum SearchRestrictBy {
		SELECT ("SELECT",0, new BigInteger("0")),
		ORGANIZATION_LOCATION ("ORGANIZATION/LOCATION",1, new BigInteger("1000004236")),
		PEOPLE ("PEOPLE",2, new BigInteger("1000004235"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private SearchRestrictBy(String searchFor, int index, BigInteger id) {
			this.name = searchFor;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	/*			ORGANIZATION			*/		
	public enum OrganizationType {
		SELECT ("Select",0, new BigInteger("0")),
		EDUCATION ("EDUCATION",1, new BigInteger("6992")),
		PROVIDER ("PROVIDER",2, new BigInteger("6991")),
		STATE_OF_MAINE ("STATE OF MAINE",3, new BigInteger("6994")),
		LAW_ENFORCEMENT ("LAW ENFORCEMENT",4, new BigInteger("1000001071")),
		HOSPTIAL ("HOSPTIAL",5, new BigInteger("1000001091")),
		OTHER ("OTHER",6, new BigInteger("6996"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private OrganizationType(String searchFor, int index, BigInteger id) {
			this.name = searchFor;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	/*			LOCATION			*/		
	public enum LocationType {
		SELECT ("Select",0, new BigInteger("0")),
		BASE ("BASE",1, new BigInteger("579128")),
		OTHER_LOCATION ("OTHER_LOCATION",2, new BigInteger("579129"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private LocationType(String searchFor, int index, BigInteger id) {
			this.name = searchFor;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	/*			ASSOCIATION			*/	
	public enum AssociationType {
		SELECT ("Select",0, new BigInteger("0")),
		INDIVIDUAL ("INDIVIDUAL",1, new BigInteger("577710")),
		ORGANIZATION ("ORGANIZATION",2, new BigInteger("577709")),
		SERVICE_POPULATION ("SERVICE POPULATION",3, new BigInteger("577708"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private AssociationType(String searchFor, int index, BigInteger id) {
			this.name = searchFor;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	public enum IndividualTitle {
		NULL ("NULL",-1, new BigInteger("-1")),
		SELECT ("Select",0, new BigInteger("0")),
		ADVOCATE_STATE ("ADVOCATE, STATE",1, new BigInteger("578988")),
		BI_CARE_COORDINATOR ("BI CARE COORDINATOR",2, new BigInteger("578989")),
		CS_ENROLLMENT_SPECIALIST ("CS ENROLLMENT SPECIALIST",3, new BigInteger("578990")),
		DISABILITY_RIGHTS_CENTER_RELATIONSHIP ("DISABILITY RIGHTS CENTER RELATIONSHIP",4, new BigInteger("578991")),
		DS_ICF_LIAISON ("DS ICF LIAISON",5, new BigInteger("578992")),
		DS_INDIVIDUAL_SUPPORT_COORDINATOR_COMMUNITY ("DS INDIVIDUAL SUPPORT COORDINATOR - COMMUNITY",6, new BigInteger("578993")),
		DS_INDIVIDUAL_SUPPORT_COORDINATOR_STATE ("DS INDIVIDUAL SUPPORT COORDINATOR, STATE",7, new BigInteger("578994")),
		DS_INDIVIDUAL_SUPPORT_COORDINATOR_STATE_SECONDARY ("DS INDIVIDUAL SUPPORT COORDINATOR, STATE SECONDARYR",8, new BigInteger("578995")),
		GUARDIAN_REPRESENTATIVE_STATE ("GUARDIAN REPRESENTATIVE (STATE)",9, new BigInteger("578996")),
		LIMITED_CONTACT_DHHS_STAFF ("LIMITED CONTACT - DHHS STAFF",11, new BigInteger("578997")),
		MH_INTENSIVE_CASE_MANAGER ("MH INTENSIVE CASE MANAGER",12, new BigInteger("578998")),
		ORC_PROVIDER_CARE_COORDINATOR ("ORC PROVIDER CARE COORDINATOR",13, new BigInteger("578999")),
		REPRESENTATIVE_PAYEE_SPECIALIST_STATE ("REPRESENTATIVE PAYEE SPECIALIST (STATE)",14, new BigInteger("579000")),
		SIXTEEN_YEAR_OLD_TRANSFER_RELATIONSHIP ("SIXTEEN YEAR OLD TRANSFER RELATIONSHIP",15, new BigInteger("579001")),
		SOCIAL_SERVICE_DESIGNEE ("SOCIAL SERVICE DESIGNEE",16, new BigInteger("579002"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private IndividualTitle(String searchFor, int index, BigInteger id) {
			this.name = searchFor;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	/*			DATA TABLE			*/	
	public enum DataTableHeaders {
		ID ("Id",1),
		NAME_TYPE ("Name/Type",2),
		START_DATE ("Start Date",3),
		END_DATE ("End Date",4),
		MODIFIED_DATE ("Modified Date",4);

		private final String name;    
		private final int index;

		private DataTableHeaders(String headerTitle, int index) {
			this.name = headerTitle;
			this.index = index;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}
	}

	/*			RESIDENTIAL PLACEMENT			*/	
	public enum PlacementType {
		SELECT ("Select",0, new BigInteger("0")),
		IN_STATE_PLACEMENT ("IN STATE PLACEMENT",1, new BigInteger("0")),//Update id when in prod
		OUT_STATE_PLACEMENT ("OUT OF STATE PLACEMENT",2, new BigInteger("0"));//Update id when in prod

		private final String name;    
		private final int index;
		private final BigInteger id;

		private PlacementType(String placementType, int index, BigInteger id) {
			this.name = placementType;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	public enum PNMILevel {
		SELECT ("Select",0, new BigInteger("0")),
		MH_I ("MH I",1, new BigInteger("0")),//Update id when in prod
		MH_II ("MH II",2, new BigInteger("0")),//Update id when in prod
		ID_I ("ID I",3, new BigInteger("0")),//Update id when in prod
		ID_II ("ID II",4, new BigInteger("0"));//Update id when in prod

		private final String name;    
		private final int index;
		private final BigInteger id;

		private PNMILevel(String level, int index, BigInteger id) {
			this.name = level;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	public enum PNMIPlacement {
		SELECT ("Select",0, new BigInteger("0")),
		AMERICAN_SCHOOL_FOR_THE_DEAF_CT ("AMERICAN SCHOOL FOR THE DEAF - CT",1, new BigInteger("1000003426"));
		//TODO: Finish adding Placements
		//MH_II ("MH II",2, new BigInteger("0")),
		//ID_I ("ID I",3, new BigInteger("0")),
		//ID_II ("ID II",4, new BigInteger("0"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private PNMIPlacement(String placement, int index, BigInteger id) {
			this.name = placement;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	/*			DEMOGRAPHICS			*/
	public enum Gender {
		SELECT ("Select",0, new BigInteger("0")),
		FEMALE ("FEMALE",1, new BigInteger("7081")),
		MALE ("MALE",2, new BigInteger("7080")),
		NON_BINARY ("NON BINARY",3, new BigInteger("1000004334")),
		UNKNOWN ("UNKNOWN",4, new BigInteger("7106"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private Gender(String gender, int index, BigInteger id) {
			this.name = gender;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	public enum MaritalStatus {
		SELECT ("Select",0, new BigInteger("0")),
		DIVORCED ("DIVORCED",1, new BigInteger("6048")),
		MARRIED_SPOUSE_PRESENT ("MARRIED - SPOUSE PRESENT",2, new BigInteger("6045")),
		MARRIED_SPOUSE_ABSENT ("MARRIED - SPOUSE ABSENT",3, new BigInteger("7116")),
		MARRIED_SEPARATED ("MARRIED - SEPARATED",4, new BigInteger("6046")),
		NEVER_MARRIED ("NEVER MARRIED",5, new BigInteger("6047")),
		REGISTERED_DOMESTIC_PARTNER ("REGISTERED DOMESTIC PARTNER",1, new BigInteger("13347")),
		WIDOWED ("WIDOWED",6, new BigInteger("7107")),
		UNKNOWN ("UNKNOWN",7, new BigInteger("7108"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private MaritalStatus(String marital, int index, BigInteger id) {
			this.name = marital;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	public enum MilitaryStatus {
		SELECT ("Select",0, new BigInteger("0")),
		ACTIVE_RESERVE ("ACTIVE RESERVE",1, new BigInteger("12371")),
		DISHONORABLE_DISCHARGE ("DISHONORABLE DISCHARGE",2, new BigInteger("7131")),
		HONORABLE_DISCHARGE ("HONORABLE DISCHARGE",3, new BigInteger("7128")),
		IN_SERVICE ("IN SERVICE",4, new BigInteger("7129")),
		INACTIVE_RESERVE ("INACTIVE RESERVE",5, new BigInteger("7130")),
		NEVER_IN_SERVICE ("NEVER IN SERVICE",6, new BigInteger("7105")),
		RETIRED ("RETIRED",7, new BigInteger("7132")),
		UNKNOWN ("UNKNOWN",8, new BigInteger("7109"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private MilitaryStatus(String military, int index, BigInteger id) {
			this.name = military;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	public enum MilitaryService {
		SELECT ("Select",0, new BigInteger("0")),
		AIR_FORCE ("AIR FORCE",1, new BigInteger("6167")),
		ARMY ("ARMY",2, new BigInteger("6164")),
		COAST_GUARD ("COAST GUARD",3, new BigInteger("6168")),
		MARINES ("MARINES",4, new BigInteger("6165")),
		NATIONAL_GUARD ("NATIONAL GUARD",5, new BigInteger("6169")),
		NATIONAL_HEALTH_SERVICE_CORPS ("NATIONAL HEALTH SERVICE CORPS",6, new BigInteger("6170")),
		NAVY ("NAVY",7, new BigInteger("6171")),
		OTHER ("OTHER",8, new BigInteger("6166")),
		UNKNOWN ("UNKNOWN",9, new BigInteger("6172"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private MilitaryService(String military, int index, BigInteger id) {
			this.name = military;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	public enum CitizenshipStatus {
		SELECT ("Select",0, new BigInteger("0")),
		NOT_A_US_CITIZEN ("NOT A US CITIZEN",1, new BigInteger("6250")),
		NOT_A_US_CITIZEN_ALIEN_RESIDENT ("NOT A US CITIZEN-ALIEN RESIDENT",2, new BigInteger("6249")),
		UNKNOWN ("UNKNOWN",3, new BigInteger("6246")),
		US_CITIZEN_BORN_ABROAD_OF_US_PARENTS ("US CITIZEN-BORN ABROAD OF US PARENTS",4, new BigInteger("6244")),
		US_CITIZEN_BORN_IN_PUERTO_RICO_OR_OTHER_TERRITORY ("US CITIZEN-BORN IN PUERTO RICO OR OTHER TERRITORY",5, new BigInteger("6247")),
		US_CITIZEN_BORN_IN_US ("US CITIZEN-BORN IN US",6, new BigInteger("6245")),
		US_CITIZEN_NATURALIZED ("US CITIZEN-NATURALIZED",7, new BigInteger("6248")),
		US_CITIZEN_UNSPECIFIED ("US CITIZEN-UNSPECIFIED",8, new BigInteger("12363"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private CitizenshipStatus(String citizenship, int index, BigInteger id) {
			this.name = citizenship;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}
	
	public enum State {
		Select ("Select", 0, new BigInteger("")),
		N1000 ("-1000", 1, new BigInteger("-1000")),
		N165 ("165", 2, new BigInteger("165")),
		N166 ("166", 3, new BigInteger("166")),
		AK ("AK", 4, new BigInteger("AK")),
		AL ("AL", 5, new BigInteger("AL")),
		AR ("AR", 6, new BigInteger("AR")),
		AZ ("AZ", 7, new BigInteger("AZ")),
		CA ("CA", 8, new BigInteger("CA")),
		CO ("CO", 9, new BigInteger("CO")),
		CT ("CT", 10, new BigInteger("CT")),
		DC ("DC", 11, new BigInteger("DC")),
		DE ("DE", 12, new BigInteger("DE")),
		FL ("FL", 13, new BigInteger("FL")),
		GA ("GA", 14, new BigInteger("GA")),
		HI ("HI", 15, new BigInteger("HI")),
		IA ("IA", 16, new BigInteger("IA")),
		ID ("ID", 17, new BigInteger("ID")),
		IL ("IL", 18, new BigInteger("IL")),
		IN ("IN", 19, new BigInteger("IN")),
		KS ("KS", 20, new BigInteger("KS")),
		KY ("KY", 21, new BigInteger("KY")),
		LA ("LA", 22, new BigInteger("LA")),
		MA ("MA", 23, new BigInteger("MA")),
		MD ("MD", 24, new BigInteger("MD")),
		ME ("ME", 25, new BigInteger("ME")),
		MH ("MH", 26, new BigInteger("MH")),
		MI ("MI", 27, new BigInteger("MI")),
		MN ("MN", 28, new BigInteger("MN")),
		MO ("MO", 29, new BigInteger("MO")),
		MS ("MS", 30, new BigInteger("MS")),
		MT ("MT", 31, new BigInteger("MT")),
		MX ("MX", 32, new BigInteger("MX")),
		NB ("NB", 33, new BigInteger("NB")),
		NC ("NC", 34, new BigInteger("NC")),
		ND ("ND", 35, new BigInteger("ND")),
		NE ("NE", 36, new BigInteger("NE")),
		NH ("NH", 37, new BigInteger("NH")),
		NJ ("NJ", 38, new BigInteger("NJ")),
		NM ("NM", 39, new BigInteger("NM")),
		NS ("NS", 40, new BigInteger("NS")),
		NV ("NV", 41, new BigInteger("NV")),
		NY ("NY", 42, new BigInteger("NY")),
		OH ("OH", 43, new BigInteger("OH")),
		OK ("OK", 44, new BigInteger("OK")),
		ON ("ON", 45, new BigInteger("ON")),
		OR ("OR", 46, new BigInteger("OR")),
		PA ("PA", 47, new BigInteger("PA")),
		PR ("PR", 48, new BigInteger("PR")),
		QC ("QC", 49, new BigInteger("QC")),
		RI ("RI", 50, new BigInteger("RI")),
		SC ("SC", 51, new BigInteger("SC")),
		SD ("SD", 52, new BigInteger("SD")),
		SK ("SK", 53, new BigInteger("SK")),
		TN ("TN", 54, new BigInteger("TN")),
		TX ("TX", 55, new BigInteger("TX")),
		UT ("UT", 56, new BigInteger("UT")),
		VA ("VA", 57, new BigInteger("VA")),
		VT ("VT", 58, new BigInteger("VT")),
		WA ("WA", 59, new BigInteger("WA")),
		WI ("WI", 60, new BigInteger("WI")),
		WV ("WV", 61, new BigInteger("WV")),
		WY ("WY", 62, new BigInteger("WY")),
		YT ("YT", 63, new BigInteger("YT"));

		private final String Abbr;    
		private final int index;
		private final BigInteger id;

		private State(String stateAbbr, int index, BigInteger id) {
			this.Abbr = stateAbbr;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getAbbr() {
			return this.Abbr;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	public enum Country {
		//TODO: Completed
		Select ("Select", 0, new BigInteger("0")),
		AFGHANISTAN ("AFGHANISTAN", 1, new BigInteger("575950")),
		ALBANIA ("ALBANIA", 2, new BigInteger("575713")),
		ALGERIA ("ALGERIA", 3, new BigInteger("575766")),
		AMERICAN_SAMOA ("AMERICAN SAMOA", 4, new BigInteger("575719")),
		ANDORRA ("ANDORRA", 5, new BigInteger("575948")),
		ANGOLA ("ANGOLA", 6, new BigInteger("575716")),
		ANGUILLA ("ANGUILLA", 7, new BigInteger("575712")),
		ANTARCTICA ("ANTARCTICA", 8, new BigInteger("575717")),
		ANTIGUA_AND_BARBUDA ("ANTIGUA AND BARBUDA", 9, new BigInteger("575711")),
		ARGENTINA ("ARGENTINA", 10, new BigInteger("575718")),
		ARMENIA ("ARMENIA", 11, new BigInteger("575714")),
		ARUBA ("ARUBA", 12, new BigInteger("575722")),
		AUSTRALIA ("AUSTRALIA", 13, new BigInteger("575721")),
		AUSTRIA ("AUSTRIA", 14, new BigInteger("575720")),
		AZERBAIDJAN ("AZERBAIDJAN", 15, new BigInteger("575723")),
		BAHAMAS ("BAHAMAS", 16, new BigInteger("575737")),
		BAHRAIN ("BAHRAIN", 17, new BigInteger("575730")),
		BANGLADESH ("BANGLADESH", 18, new BigInteger("575726")),
		BARBADOS ("BARBADOS", 19, new BigInteger("575725")),
		BELARUS ("BELARUS", 20, new BigInteger("575741")),
		BELGIUM ("BELGIUM", 21, new BigInteger("575727")),
		BELIZE ("BELIZE", 22, new BigInteger("575742")),
		BENIN ("BENIN", 23, new BigInteger("575732")),
		BERMUDA ("BERMUDA", 24, new BigInteger("575733")),
		BOLIVIA ("BOLIVIA", 25, new BigInteger("575735")),
		BOSNIA_HERZEGOVINA ("BOSNIA-HERZEGOVINA", 26, new BigInteger("575724")),
		BOTSWANA ("BOTSWANA", 27, new BigInteger("575740")),
		BOUVET_ISLAND ("BOUVET ISLAND", 28, new BigInteger("575739")),
		BRAZIL ("BRAZIL", 29, new BigInteger("575736")),
		BRITISH_INDIAN_O_TERR ("BRITISH INDIAN O. TERR.", 30, new BigInteger("575807")),
		BRUNEI_DARUSSALAM ("BRUNEI DARUSSALAM", 31, new BigInteger("575734")),
		BULGARIA ("BULGARIA", 32, new BigInteger("575729")),
		BURKINA_FASO ("BURKINA FASO", 33, new BigInteger("575728")),
		BURUNDI ("BURUNDI", 34, new BigInteger("575731")),
		BUTHAN ("BUTHAN", 35, new BigInteger("575738")),
		CAMBODIA ("CAMBODIA", 36, new BigInteger("575817")),
		CAMEROON ("CAMEROON", 37, new BigInteger("575751")),
		CANADA ("CANADA", 38, new BigInteger("575743")),
		CAPE_VERDE ("CAPE VERDE", 39, new BigInteger("575757")),
		CAYMAN_ISLANDS ("CAYMAN ISLANDS", 40, new BigInteger("575824")),
		CENTRAL_AFRICAN_REP ("CENTRAL AFRICAN REP.", 41, new BigInteger("575745")),
		CHAD ("CHAD", 42, new BigInteger("575910")),
		CHILE ("CHILE", 43, new BigInteger("575750")),
		CHINA ("CHINA", 44, new BigInteger("575752")),
		CHRISTMAS_ISLAND ("CHRISTMAS ISLAND", 45, new BigInteger("575758")),
		COCOS_KEELING_ISL ("COCOS (KEELING) ISL.", 46, new BigInteger("575744")),
		COLOMBIA ("COLOMBIA", 47, new BigInteger("575753")),
		COMOROS ("COMOROS", 48, new BigInteger("575819")),
		CONGO ("CONGO", 49, new BigInteger("575746")),
		COOK_ISLANDS ("COOK ISLANDS", 50, new BigInteger("575749")),
		COSTA_RICA ("COSTA RICA", 51, new BigInteger("575754")),
		CROATIA ("CROATIA", 52, new BigInteger("575800")),
		CUBA ("CUBA", 53, new BigInteger("575756")),
		CYPRUS ("CYPRUS", 54, new BigInteger("575759")),
		CZECH_REPUBLIC ("CZECH REPUBLIC", 55, new BigInteger("575760")),
		CZECHOSLOVAKIA ("CZECHOSLOVAKIA", 56, new BigInteger("575755")),
		DENMARK ("DENMARK", 57, new BigInteger("575763")),
		DJIBOUTI ("DJIBOUTI", 58, new BigInteger("575762")),
		DOMINICA ("DOMINICA", 59, new BigInteger("575764")),
		DOMINICAN_REPUBLIC ("DOMINICAN REPUBLIC", 60, new BigInteger("575765")),
		EAST_TIMOR ("EAST TIMOR", 61, new BigInteger("575919")),
		ECUADOR ("ECUADOR", 62, new BigInteger("575767")),
		EGYPT ("EGYPT", 63, new BigInteger("575769")),
		EL_SALVADOR ("EL SALVADOR", 64, new BigInteger("575906")),
		EQUATORIAL_GUINEA ("EQUATORIAL GUINEA", 65, new BigInteger("575788")),
		ESTONIA ("ESTONIA", 66, new BigInteger("575768")),
		ETHIOPIA ("ETHIOPIA", 67, new BigInteger("575772")),
		FALKLAND_ISLMALVINAS ("FALKLAND ISL.(MALVINAS)", 68, new BigInteger("575775")),
		FAROE_ISLANDS ("FAROE ISLANDS", 69, new BigInteger("575777")),
		FIJI ("FIJI", 70, new BigInteger("575774")),
		FINLAND ("FINLAND", 71, new BigInteger("575773")),
		FRANCE ("FRANCE", 72, new BigInteger("575778")),
		FRANCE_EUROPEAN_TER ("FRANCE (EUROPEAN TER.)", 73, new BigInteger("575779")),
		FRENCH_SOUTHERN_TERR ("FRENCH SOUTHERN TERR.", 74, new BigInteger("575911")),
		GABON ("GABON", 75, new BigInteger("575780")),
		GAMBIA ("GAMBIA", 76, new BigInteger("575790")),
		GEORGIA ("GEORGIA", 77, new BigInteger("575783")),
		GERMANY ("GERMANY", 78, new BigInteger("575761")),
		GHANA ("GHANA", 79, new BigInteger("575784")),
		GIBRALTAR ("GIBRALTAR", 80, new BigInteger("575785")),
		GREAT_BRITAIN_UK ("GREAT BRITAIN (UK)", 81, new BigInteger("575781")),
		GREECE ("GREECE", 82, new BigInteger("575792")),
		GREENLAND ("GREENLAND", 83, new BigInteger("575786")),
		GRENADA ("GRENADA", 84, new BigInteger("575782")),
		GUADELOUPE_FR ("GUADELOUPE (FR.)", 85, new BigInteger("575787")),
		GUAM_US ("GUAM (US)", 86, new BigInteger("575794")),
		GUATEMALA ("GUATEMALA", 87, new BigInteger("575793")),
		GUINEA ("GUINEA", 88, new BigInteger("575791")),
		GUINEA_BISSAU ("GUINEA BISSAU", 89, new BigInteger("575795")),
		GUYANA ("GUYANA", 90, new BigInteger("575796")),
		GUYANA_FR ("GUYANA (FR.)", 91, new BigInteger("575789")),
		HAITI ("HAITI", 92, new BigInteger("575801")),
		HEARD_MCDONALD_ISL ("HEARD & MCDONALD ISL.", 93, new BigInteger("575798")),
		HONDURAS ("HONDURAS", 94, new BigInteger("575799")),
		HONG_KONG ("HONG KONG", 95, new BigInteger("575797")),
		HUNGARY ("HUNGARY", 96, new BigInteger("575802")),
		ICELAND ("ICELAND", 97, new BigInteger("575810")),
		INDIA ("INDIA", 98, new BigInteger("575806")),
		INDONESIA ("INDONESIA", 99, new BigInteger("575803")),
		IRAN ("IRAN", 100, new BigInteger("575809")),
		IRAQ ("IRAQ", 101, new BigInteger("575808")),
		IRELAND ("IRELAND", 102, new BigInteger("575804")),
		ISRAEL ("ISRAEL", 103, new BigInteger("575805")),
		ITALY ("ITALY", 104, new BigInteger("575811")),
		IVORY_COAST ("IVORY COAST", 105, new BigInteger("575748")),
		JAMAICA ("JAMAICA", 106, new BigInteger("575812")),
		JAPAN ("JAPAN", 107, new BigInteger("575814")),
		JORDAN ("JORDAN", 108, new BigInteger("575813")),
		KAZACHSTAN ("KAZACHSTAN", 109, new BigInteger("575825")),
		KENYA ("KENYA", 110, new BigInteger("575815")),
		KIRGISTAN ("KIRGISTAN", 111, new BigInteger("575816")),
		KIRIBATI ("KIRIBATI", 112, new BigInteger("575818")),
		KOREA_NORTH ("KOREA (NORTH)", 113, new BigInteger("575821")),
		KOREA_SOUTH ("KOREA (SOUTH)", 114, new BigInteger("575822")),
		KUWAIT ("KUWAIT", 115, new BigInteger("575823")),
		LAOS ("LAOS", 116, new BigInteger("575826")),
		LATVIA ("LATVIA", 117, new BigInteger("575835")),
		LEBANON ("LEBANON", 118, new BigInteger("575827")),
		LESOTHO ("LESOTHO", 119, new BigInteger("575832")),
		LIBERIA ("LIBERIA", 120, new BigInteger("575831")),
		LIBYA ("LIBYA", 121, new BigInteger("575836")),
		LIECHTENSTEIN ("LIECHTENSTEIN", 122, new BigInteger("575829")),
		LITHUANIA ("LITHUANIA", 123, new BigInteger("575833")),
		LUXEMBOURG ("LUXEMBOURG", 124, new BigInteger("575834")),
		MACAU ("MACAU", 125, new BigInteger("575845")),
		MADAGASCAR ("MADAGASCAR", 126, new BigInteger("575840")),
		MALAWI ("MALAWI", 127, new BigInteger("575853")),
		MALAYSIA ("MALAYSIA", 128, new BigInteger("575855")),
		MALDIVES ("MALDIVES", 129, new BigInteger("575852")),
		MALI ("MALI", 130, new BigInteger("575842")),
		MALTA ("MALTA", 131, new BigInteger("575850")),
		MARSHALL_ISLANDS ("MARSHALL ISLANDS", 132, new BigInteger("575841")),
		MARTINIQUE_FR ("MARTINIQUE (FR.)", 133, new BigInteger("575847")),
		MAURITANIA ("MAURITANIA", 134, new BigInteger("575848")),
		MAURITIUS ("MAURITIUS", 135, new BigInteger("575851")),
		MEXICO ("MEXICO", 136, new BigInteger("575854")),
		MICRONESIA ("MICRONESIA", 137, new BigInteger("575776")),
		MOLDAVIA ("MOLDAVIA", 138, new BigInteger("575839")),
		MONACO ("MONACO", 139, new BigInteger("575838")),
		MONGOLIA ("MONGOLIA", 140, new BigInteger("575844")),
		MONTSERRAT ("MONTSERRAT", 141, new BigInteger("575849")),
		MOROCCO ("MOROCCO", 142, new BigInteger("575837")),
		MOZAMBIQUE ("MOZAMBIQUE", 143, new BigInteger("575856")),
		MYANMAR ("MYANMAR", 144, new BigInteger("575843")),
		NAMIBIA ("NAMIBIA", 145, new BigInteger("575857")),
		NAURU ("NAURU", 146, new BigInteger("575866")),
		NEPAL ("NEPAL", 147, new BigInteger("575865")),
		NETHERLAND_ANTILLES ("NETHERLAND ANTILLES", 148, new BigInteger("575715")),
		NETHERLANDS ("NETHERLANDS", 149, new BigInteger("575863")),
		NEUTRAL_ZONE ("NEUTRAL ZONE", 150, new BigInteger("575867")),
		NEW_CALEDONIA_FR ("NEW CALEDONIA (FR.)", 151, new BigInteger("575858")),
		NEW_ZEALAND ("NEW ZEALAND", 152, new BigInteger("575869")),
		NICARAGUA ("NICARAGUA", 153, new BigInteger("575862")),
		NIGER ("NIGER", 154, new BigInteger("575859")),
		NIGERIA ("NIGERIA", 155, new BigInteger("575861")),
		NIUE ("NIUE", 156, new BigInteger("575868")),
		NORFOLK_ISLAND ("NORFOLK ISLAND", 157, new BigInteger("575860")),
		NORTHERN_MARIANA_ISL ("NORTHERN MARIANA ISL.", 158, new BigInteger("575846")),
		NORWAY ("NORWAY", 159, new BigInteger("575864")),
		OMAN ("OMAN", 160, new BigInteger("575870")),
		OTHER ("OTHER", 161, new BigInteger("575951")),
		PAKISTAN ("PAKISTAN", 162, new BigInteger("575876")),
		PALAU ("PALAU", 163, new BigInteger("575882")),
		PANAMA ("PANAMA", 164, new BigInteger("575871")),
		PAPUA_NEW_GUINEA ("PAPUA NEW GUINEA", 165, new BigInteger("575874")),
		PARAGUAY ("PARAGUAY", 166, new BigInteger("575883")),
		PERU ("PERU", 167, new BigInteger("575872")),
		PHILIPPINES ("PHILIPPINES", 168, new BigInteger("575875")),
		PITCAIRN ("PITCAIRN", 169, new BigInteger("575879")),
		POLAND ("POLAND", 170, new BigInteger("575877")),
		POLYNESIA_FR ("POLYNESIA (FR.)", 171, new BigInteger("575873")),
		PORTUGAL ("PORTUGAL", 172, new BigInteger("575880")),
		PUERTO_RICO_US ("PUERTO RICO (US)", 173, new BigInteger("575881")),
		QATAR ("QATAR", 174, new BigInteger("575884")),
		REUNION_FR ("REUNION (FR.)", 175, new BigInteger("575885")),
		ROMANIA ("ROMANIA", 176, new BigInteger("575886")),
		RUSSIAN_FEDERATION ("RUSSIAN FEDERATION", 177, new BigInteger("575887")),
		RWANDA ("RWANDA", 178, new BigInteger("575888")),
		SAINT_LUCIA ("SAINT LUCIA", 179, new BigInteger("575828")),
		SAMOA ("SAMOA", 180, new BigInteger("575940")),
		SAN_MARINO ("SAN MARINO", 181, new BigInteger("575900")),
		SAUDI_ARABIA ("SAUDI ARABIA", 182, new BigInteger("575889")),
		SENEGAL ("SENEGAL", 183, new BigInteger("575901")),
		SEYCHELLES ("SEYCHELLES", 184, new BigInteger("575891")),
		SIERRA_LEONE ("SIERRA LEONE", 185, new BigInteger("575899")),
		SINGAPORE ("SINGAPORE", 186, new BigInteger("575894")),
		SLOVAK_REPUBLIC ("SLOVAK REPUBLIC", 187, new BigInteger("575898")),
		SLOVENIA ("SLOVENIA", 188, new BigInteger("575896")),
		SOLOMON_ISLANDS ("SOLOMON ISLANDS", 189, new BigInteger("575890")),
		SOMALIA ("SOMALIA", 190, new BigInteger("575902")),
		SOUTH_AFRICA ("SOUTH AFRICA", 191, new BigInteger("575943")),
		SOVIET_UNION ("SOVIET UNION", 192, new BigInteger("575905")),
		SPAIN ("SPAIN", 193, new BigInteger("575771")),
		SRI_LANKA ("SRI LANKA", 194, new BigInteger("575830")),
		ST_HELENA ("ST. HELENA", 195, new BigInteger("575895")),
		ST_PIERRE_MIQUELON ("ST. PIERRE & MIQUELON", 196, new BigInteger("575878")),
		ST_TOME_AND_PRINCIPE ("ST. TOME AND PRINCIPE", 197, new BigInteger("575904")),
		STKITTS_NEVIS_ANGUILLA ("ST.KITTS NEVIS ANGUILLA", 198, new BigInteger("575820")),
		STVINCENT_GRENADINES ("ST.VINCENT & GRENADINES", 199, new BigInteger("575933")),
		SUDAN ("SUDAN", 200, new BigInteger("575892")),
		SURINAME ("SURINAME", 201, new BigInteger("575903")),
		SVALBARD_JAN_MAYEN_ISLANDS ("SVALBARD & JAN MAYEN ISLANDS", 202, new BigInteger("575897")),
		SWAZILAND ("SWAZILAND", 203, new BigInteger("575908")),
		SWEDEN ("SWEDEN", 204, new BigInteger("575893")),
		SWITZERLAND ("SWITZERLAND", 205, new BigInteger("575747")),
		SYRIA ("SYRIA", 206, new BigInteger("575907")),
		TADJIKISTAN ("TADJIKISTAN", 207, new BigInteger("575914")),
		TAIWAN ("TAIWAN", 208, new BigInteger("575923")),
		TANZANIA ("TANZANIA", 209, new BigInteger("575924")),
		THAILAND ("THAILAND", 210, new BigInteger("575913")),
		TOGO ("TOGO", 211, new BigInteger("575912")),
		TOKELAU ("TOKELAU", 212, new BigInteger("575915")),
		TONGA ("TONGA", 213, new BigInteger("575918")),
		TRINIDAD_TOBAGO ("TRINIDAD & TOBAGO", 214, new BigInteger("575921")),
		TUNISIA ("TUNISIA", 215, new BigInteger("575917")),
		TURKEY ("TURKEY", 216, new BigInteger("575920")),
		TURKMENISTAN ("TURKMENISTAN", 217, new BigInteger("575916")),
		TURKS_CAICOS_ISLANDS ("TURKS & CAICOS ISLANDS", 218, new BigInteger("575909")),
		TUVALU ("TUVALU", 219, new BigInteger("575922")),
		UGANDA ("UGANDA", 220, new BigInteger("575926")),
		UKRAINE ("UKRAINE", 221, new BigInteger("575925")),
		UNITED_ARAB_EMIRATES ("UNITED ARAB EMIRATES", 222, new BigInteger("575949")),
		UNITED_KINGDOM ("UNITED KINGDOM", 223, new BigInteger("575927")),
		UNITED_STATES ("UNITED STATES", 224, new BigInteger("575929")),
		UNKNOWN ("UNKNOWN", 225, new BigInteger("575952")),
		URUGUAY ("URUGUAY", 226, new BigInteger("575930")),
		US_MINOR_OUTLYING_ISL ("US MINOR OUTLYING ISL.", 227, new BigInteger("575928")),
		UZBEKISTAN ("UZBEKISTAN", 228, new BigInteger("575931")),
		VANUATU ("VANUATU", 229, new BigInteger("575938")),
		VATICAN_CITY_STATE ("VATICAN CITY STATE", 230, new BigInteger("575932")),
		VENEZUELA ("VENEZUELA", 231, new BigInteger("575934")),
		VIETNAM ("VIETNAM", 232, new BigInteger("575937")),
		VIRGIN_ISLANDS_BRITISH ("VIRGIN ISLANDS (BRITISH)", 233, new BigInteger("575935")),
		VIRGIN_ISLANDS_US ("VIRGIN ISLANDS (US)", 234, new BigInteger("575936")),
		WALLIS_FUTUNA_ISLANDS ("WALLIS & FUTUNA ISLANDS", 235, new BigInteger("575939")),
		WESTERN_SAHARA ("WESTERN SAHARA", 236, new BigInteger("575770")),
		YEMEN ("YEMEN", 237, new BigInteger("575941")),
		YUGOSLAVIA ("YUGOSLAVIA", 238, new BigInteger("575942")),
		ZAIRE ("ZAIRE", 239, new BigInteger("575945")),
		ZAMBIA ("ZAMBIA", 240, new BigInteger("575944")),
		ZIMBABWE ("ZIMBABWE", 241, new BigInteger("575946"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private Country(String country, int index, BigInteger id) {
			this.name = country;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	/*			IDENTIFIER			*/
	public enum Identifier {
		SELECT ("Select",0, new BigInteger("0")),
		MEDICAID ("MEDICAID",1, new BigInteger("575270")),
		SSN ("SOCIAL SECURITY NUMBER",2, new BigInteger("575269")),
		DOC_NUMBER_CORRECTIONS ("DOC NUMBER (CORRECTIONS)",3, new BigInteger("1000000066")),
		DRIVERS_LICENSE ("DRIVER'S LICENSE NUMBER",4, new BigInteger("1000000271")),
		PRIVATE_INSURANCE ("PRIVATE INSURANCE",5, new BigInteger("1000002231"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private Identifier(String identifier, int index, BigInteger id) {
			this.name = identifier;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	/*			Language			*/
	public enum Language {
		//TODO: Completed
		Select ("Select", 0, new BigInteger("0")),
		AMHARIC ("AMHARIC", 1, new BigInteger("6070")),
		ARABIC ("ARABIC", 2, new BigInteger("7177")),
		ARMENIAN ("ARMENIAN", 3, new BigInteger("7184")),
		BENGALI ("BENGALI", 4, new BigInteger("6055")),
		CAJUN ("CAJUN", 5, new BigInteger("6069")),
		CANTONESE ("CANTONESE", 6, new BigInteger("1000002331")),
		CHINESE ("CHINESE", 7, new BigInteger("7168")),
		CROATIAN ("CROATIAN", 8, new BigInteger("6067")),
		CZECH ("CZECH", 9, new BigInteger("6058")),
		DANISH ("DANISH", 10, new BigInteger("7164")),
		DUTCH ("DUTCH", 11, new BigInteger("6054")),
		ENGLISH ("ENGLISH", 12, new BigInteger("7202")),
		FARSI ("FARSI", 13, new BigInteger("1000002333")),
		FRENCH ("FRENCH", 14, new BigInteger("7165")),
		FRENCH_CANADIAN ("FRENCH CANADIAN", 15, new BigInteger("13019")),
		GERMAN ("GERMAN", 16, new BigInteger("7166")),
		GREEK ("GREEK", 17, new BigInteger("7176")),
		HEBREW ("HEBREW", 18, new BigInteger("6053")),
		HINDI_URDU ("HINDI (URDU)", 19, new BigInteger("7178")),
		HUNGARIAN ("HUNGARIAN", 20, new BigInteger("6052")),
		INDONESIAN ("INDONESIAN", 21, new BigInteger("12717")),
		ITALIAN ("ITALIAN", 22, new BigInteger("7167")),
		JAPANESE ("JAPANESE", 23, new BigInteger("7174")),
		KIRUNDI ("KIRUNDI", 24, new BigInteger("1000002332")),
		KOREAN ("KOREAN", 25, new BigInteger("7171")),
		NATIVE_AMERICAN ("NATIVE AMERICAN", 26, new BigInteger("7238")),
		NORWEGIAN ("NORWEGIAN", 27, new BigInteger("6061")),
		OTHER ("OTHER", 28, new BigInteger("6071")),
		PERSIAN ("PERSIAN", 29, new BigInteger("7182")),
		POLISH ("POLISH", 30, new BigInteger("7170")),
		PORTUGUESE ("PORTUGUESE", 31, new BigInteger("7173")),
		RUMANIAN ("RUMANIAN", 32, new BigInteger("7188")),
		RUSSIAN ("RUSSIAN", 33, new BigInteger("7179")),
		SAMOAN ("SAMOAN", 34, new BigInteger("6051")),
		SIGNED_ENGLISH ("SIGNED ENGLISH", 35, new BigInteger("12456")),
		SOMALI ("SOMALI", 36, new BigInteger("13021")),
		SPANISH ("SPANISH", 37, new BigInteger("7201")),
		SWAHILI ("SWAHILI", 38, new BigInteger("1000002334")),
		SWEDISH ("SWEDISH", 39, new BigInteger("6062")),
		THAI_LAOTIAN ("THAI (LAOTIAN)", 40, new BigInteger("7181")),
		UKRAINIAN ("UKRAINIAN", 41, new BigInteger("6057")),
		UNKNOWN ("UNKNOWN", 42, new BigInteger("7180")),
		VIETNAMESE ("VIETNAMESE", 43, new BigInteger("7172"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private Language(String language, int index, BigInteger id) {
			this.name = language;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	public enum EnglishProficiency {
		SELECT ("Select",0, new BigInteger("0")),
		NOT_PROFICIENT ("NOT PROFICIENT",1, new BigInteger("12719")),
		READ ("READ",2, new BigInteger("7278")),
		READ_SPEAK_WRITE ("READ/SPEAK/WRITE",3, new BigInteger("12484")),
		READ_UNDERSTAND ("READ/UNDERSTAND",4, new BigInteger("12483")),
		READ_UNDERSTAND_WRITE ("READ/UNDERSTAND/WRITE",5, new BigInteger("12485")),
		READ_WRITE ("READ/WRITE",6, new BigInteger("12482")),
		SPEAK ("SPEAK",7, new BigInteger("7280")),
		SPEAK_READ ("SPEAK/READ",8, new BigInteger("12477")),
		SPEAK_READ_WRITE ("SPEAK/READ/WRITE",9, new BigInteger("12479")),
		SPEAK_UNDERSTAND ("SPEAK/UNDERSTAND",10, new BigInteger("7083")),
		SPEAK_UNDERSTAND_READ ("SPEAK/UNDERSTAND/READ",11, new BigInteger("12480")),
		SPEAK_UNDERSTAND_READ_WRITE ("SPEAK/UNDERSTAND/READ/WRITE",12, new BigInteger("7082")),
		SPEAK_UNDERSTAND_WRITE ("SPEAK/UNDERSTAND/WRITE",13, new BigInteger("12481")),
		SPEAK_WRITE ("SOCIAL SECURITY NUMBER",14, new BigInteger("12478")),
		UNDERSTAND ("UNDERSTAND",15, new BigInteger("7281")),
		UNDRESTAND_WRITE ("UNDRESTAND/WRITE",16, new BigInteger("12486")),
		UNKNOWN ("UNKNOWN",17, new BigInteger("12720")),
		WRITE ("WRITE",18, new BigInteger("7279"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private EnglishProficiency(String languageProficiency, int index, BigInteger id) {
			this.name = languageProficiency;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	/*			Race/Ethnicity/Other			*/	
	public enum Religion {
		SELECT ("Select",0, new BigInteger("0")),
		AGNOSTIC ("AGNOSTIC",1, new BigInteger("7239")),
		AMISH ("AMISH",2, new BigInteger("7134")),
		ASSEMBLIES_OF_GOD ("ASSEMBLIES OF GOD",3, new BigInteger("7135")),
		BAPTIST ("BAPTIST",4, new BigInteger("7136")),
		BORN_AGAIN_CHRISTIAN ("BORN AGAIN CHRISTIAN",5, new BigInteger("7137")),
		BUDDHIST ("BUDDHIST",6, new BigInteger("7138")),
		CATHOLIC ("CATHOLIC",7, new BigInteger("7139")),
		CHRISTIAN_NO_PREFERENCE ("CHRISTIAN (NO PREFERENCE)",8, new BigInteger("7141")),
		CHRISTIAN_CHURCHES ("CHRISTIAN CHURCHES",9, new BigInteger("7140")),
		CHURCH_OF_GOD ("CHURCH OF GOD",10, new BigInteger("7142")),
		CHURCH_OF_THE_NAZARENE ("CHURCH OF THE NAZARENE",11, new BigInteger("7143")),
		CONGREGATIONAL ("CONGREGATIONAL",12, new BigInteger("7145")),
		EPISCOPAL ("EPISCOPAL",13, new BigInteger("7146")),
		EVANGELICAL_CHURCHES ("EVANGELICAL CHURCHES",14, new BigInteger("12460")),
		GREEK_ORTHODOX ("GREEK ORTHODOX",15, new BigInteger("12461")),
		HINDU ("HINDU",16, new BigInteger("7147")),
		INTERNATIONAL_CHURCH_OF_THE_FOURSQUARE_GOSPEL ("INTERNATIONAL CHURCH OF THE FOURSQUARE GOSPEL",17, new BigInteger("7148")),
		JEHOVAHWITNESS ("JEHOVAH WITNESS",18, new BigInteger("7149")),
		JEWISH ("JEWISH",19, new BigInteger("7150")),
		LUTHERAN ("LUTHERAN",20, new BigInteger("7151")),
		MENNONITE ("MENNONITE",21, new BigInteger("7152")),
		METHODIST ("METHODIST",22, new BigInteger("7153")),
		MORMON ("MORMON (CHURCH OF JESUS CHRIST OF LATTER-DAY SAINTS)",23, new BigInteger("7154")),
		MUSLIM_ISLAM ("MUSLIM/ISLAM",24, new BigInteger("7155")),
		NATIVE_AMERICAN ("NATIVE AMERICAN",25, new BigInteger("12462")),
		NO_PREFERENCE ("NO PREFERENCE",26, new BigInteger("7161")),
		NONE ("NONE",27, new BigInteger("7204")),
		OTHER ("OTHER",28, new BigInteger("7203")),
		PENTECOSTAL ("PENTECOSTAL",29, new BigInteger("7156")),
		PRESBYTERIAN ("PRESBYTERIAN",30, new BigInteger("7157")),
		PROTESTANT ("PROTESTANT",31, new BigInteger("7240")),
		QUAKER ("QUAKER",32, new BigInteger("12463")),
		ROMAN_CATHOLIC ("ROMAN CATHOLIC",33, new BigInteger("12464")),
		RUSSIAN_ORTHODOX ("RUSSIAN ORTHODOX",34, new BigInteger("12465")),
		SEVENTH_DAY_ADVENTIST ("SEVENTH DAY ADVENTIST",35, new BigInteger("7158")),
		UNITARIAN_UNIVERSALIST ("UNITARIAN UNIVERSALIST",36, new BigInteger("7159")),
		UNITED_CHURCH_OF_CHRIST ("UNITED CHURCH OF CHRIST",37, new BigInteger("7160")),
		UNKNOWN ("UNKNOWN",38, new BigInteger("7205"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private Religion(String religion, int index, BigInteger id) {
			this.name = religion;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	public enum Race {
		SELECT ("Select",0, new BigInteger("0")),
		AMERICAN_INDIAN_ALASKAN_NATIVE ("AMERICAN INDIAN/ALASKAN NATIVE",1, new BigInteger("6995")),
		ASIAN ("ASIAN",2, new BigInteger("6997")),
		BLACK_AFRICAN_AMERICAN ("BLACK/AFRICAN-AMERICAN",3, new BigInteger("7001")),
		MIDDLE_EASTERN ("MIDDLE EASTERN",4, new BigInteger("579328")),
		NATIVE_HAWAIIAN_PACIFIC_ISLANDER ("NATIVE HAWAIIAN/PACIFIC ISLANDER",5, new BigInteger("7282")),
		UNKNOWN ("UNKNOWN",6, new BigInteger("7000")),
		WHITE ("WHITE",7, new BigInteger("6998"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private Race(String race, int index, BigInteger id) {
			this.name = race;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}

	public enum Ethnicity {
		SELECT ("Select",0, new BigInteger("0")),
		ASIAN_PACIFIC_ISLANDER ("ASIAN/PACIFIC ISLANDER",1, new BigInteger("579329")),
		BLACK_AFRICAN_AMERICAN ("BLACK/AFRICAN AMERICAN",2, new BigInteger("579330")),
		FRANCO_AMERICAN ("FRANCO-AMERICAN",3, new BigInteger("579331")),
		HISPANIC_LATINO ("HISPANIC/LATINO",4, new BigInteger("579332")),
		NATIVE_AMERICAN_MALISEET ("NATIVE AMERICAN-MALISEET",5, new BigInteger("579333")),
		NATIVE_AMERICAN_MICMAC ("NATIVE AMERICAN-MICMAC",6, new BigInteger("579334")),
		NATIVE_AMERICAN_NON_SPECIFIC ("NATIVE AMERICAN-NON SPECIFIC",7, new BigInteger("579335")),
		NATIVE_AMERICAN_PASSAMAQUODDY ("NATIVE AMERICAN-PASSAMAQUODDY",8, new BigInteger("579336")),
		NATIVE_AMERICAN_PENOBSCOT ("NATIVE AMERICAN-PENOBSCOT",9, new BigInteger("579337")),
		NATIVE_AMERICAN_AMERICAN_INDIAN ("NATIVE AMERICAN AMERICAN INDIAN",10, new BigInteger("579338")),
		NATIVE_HAWAIIAN_PACIFIC_ISLANDER ("NATIVE HAWAIIAN/PACIFIC ISLANDER",11, new BigInteger("1000004814")),
		AMERICAN_INDIAN_ALASKAN_NATIVE ("AMERICAN INDIAN / ALASKAN NATIVE",12, new BigInteger("1000004454")),
		UNKNOWN ("UNKNOWN",13, new BigInteger("7127")),
		WHITE_CAUCASIAN ("WHITE/CAUCASIAN",14, new BigInteger("579339")),
		OTHER ("OTHER",15, new BigInteger("1000004414"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private Ethnicity(String ethnicity, int index, BigInteger id) {
			this.name = ethnicity;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}
	
	public enum AgreementType {
		SELECT ("Select",0, new BigInteger("0")),
		CLIENT_SERVICES ("CLIENT SERVICES",1, new BigInteger("13419")),
		SPECIAL_SERVICES ("SPECIAL SERVICES",2, new BigInteger("13420")),
		RESIDENTIAL_SERVICES_ROOM_BOARD ("RESIDENTIAL SERVICES - ROOM & BOARD",3, new BigInteger("1000000061")),
		RESIDENTIAL_SERVICES_SPEND_DOWN ("RESIDENTIAL SERVICES - SPEND DOWN",4, new BigInteger("1000000062")),
		RESIDENTIAL_SERVICES_COURT_ORDERED_FORENSIC ("RESIDENTIAL SERVICES - COURT ORDERED/FORENSIC",5, new BigInteger("1000000063")),
		SECTION_17 ("SECTION 17",6, new BigInteger("1000000064")),
		CRISIS_STABILIZATION_MHS ("CRISIS STABILIZATION - MHS",7, new BigInteger("1000000065")),
		CONT ("CONT",8, new BigInteger("1000003894")),
		MCON ("MCON",9, new BigInteger("1000003895")),
		PH ("PH",10, new BigInteger("1000002814")),
		CTB ("CTB",11, new BigInteger("1000002816")),
		NS ("NS",12, new BigInteger("1000002817")),
		CS ("CS",13, new BigInteger("1000002818")),
		MVA ("MVA",14, new BigInteger("1000002819")),
		FFS ("FFS",15, new BigInteger("1000002820")),
		BP18 ("BP18",16, new BigInteger("1000002821")),
		TS ("TS",17, new BigInteger("1000002822")),
		CSI ("CSI",18, new BigInteger("1000002823"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private AgreementType(String type, int index, BigInteger id) {
			this.name = type;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}
	
	public enum OrgServices {
		SELECT ("Select",0, new BigInteger("0")),
		CRISIS ("CRISIS",1, new BigInteger("1000001652")),
		HOME_AND_COMMUNITY_TREATMENT ("HOME AND COMMUNITY TREATMENT",2, new BigInteger("1000001654")),
		OUTPATIENT ("OUTPATIENT",3, new BigInteger("1000001655")),
		PNMI ("PNMI",4, new BigInteger("1000001656")),
		RCS ("RCS",5, new BigInteger("1000001653")),
		TARGETED_CASE_MANAGEMENT ("TARGETED CASE MANAGEMENT",6, new BigInteger("1000001651")),
		MENTAL_HEALTH_AGENCY ("MENTAL HEALTH AGENCY",7, new BigInteger("1000001996")),
		MENTAL_HEALTH_SITE ("MENTAL_HEALTH_SITE",8, new BigInteger("1000001997")),
		SUBSTANCE_ABUSE_AGENCY ("SUBSTANCE ABUSE AGENCY",9, new BigInteger("1000002023")),
		SUBSTANCE_ABUSE_SITE ("SUBSTANCE ABUSE SITE",10, new BigInteger("1000002024"));

		private final String name;    
		private final int index;
		private final BigInteger id;

		private OrgServices(String service, int index, BigInteger id) {
			this.name = service;
			this.index = index;
			this.id = id;
		}

		public int getIndex() {
			return this.index;
		}

		public String getName() {
			return this.name;
		}

		public BigInteger getId() {
			return this.id;
		}

		public String getIdAsString() {
			String idAsString = String.valueOf(this.id);
			return idAsString;
		}
	}
	
}

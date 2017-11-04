

	public enum Service {
	    ARMY ("Army"),
	    NAVY ("Navy"),
	    RAF ("RAF"),
	    POLICE ("Police"),
	    FIRE ("Fire"),
	    NHS ("NHS"),
	    FAMILY ("Family"),
	    OTHER ("Other");
		private final String value;

	    private Service(final String value) {
	        this.value = value;
	    }

	    public String getValue() { return value; }
	
	}
	
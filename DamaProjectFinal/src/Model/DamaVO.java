package Model;

public class DamaVO {
	
	private String id;
	private String nick;
	private String type;
	private int exp;
	private int lv;
	private int energy;
	private int day;
	
<<<<<<< HEAD
		
=======
	
	@Override
	public String toString() {
		return "DamaVO [id=" + id + ", nick=" + nick + ", type=" + type + ", exp=" + exp + ", lv=" + lv + ", energy="
				+ energy + ", day=" + day + "]";
	}
>>>>>>> branch 'master' of https://github.com/2021-SMHRD-KDT-Bigdata-6/intj.git
	public DamaVO(String id, String nick, int lv, String type, int day) {
		this.id =id;
		this.nick = nick;
		this.type = type;
		this.lv = lv;
		this.day = day;
	}
	public DamaVO(String nick, String type, int exp, int lv, int energy, String id, int day) {
		this.nick = nick;
		this.type = type;
		this.exp=exp;
		this.lv = lv;
		this.energy = energy;
		this.id = id;
		this.day = day;
	}


	public String getId() {
		return id;
	}

	public DamaVO() {
		// TODO Auto-generated constructor stub
	}


	public DamaVO(String nick, String type) {
		this.nick = nick;
		this.type = type;
	}




	public DamaVO(String id, String nick, int lv, int exp, String type, int day) {
		this.id = id;
		this.nick = nick;
		this.lv=lv;
		this.exp = exp;
		this.type = type;
		this.day = day;
	}


	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

}

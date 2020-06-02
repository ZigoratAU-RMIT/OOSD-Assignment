package Entity;

public interface AnimalLife {
	int getLife();
	void setLife(int life);
	void decLife();
	void incLife();
	String getName();
	void setName(String name);
	boolean isAlive();
}

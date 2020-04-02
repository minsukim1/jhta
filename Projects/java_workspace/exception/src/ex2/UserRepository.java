package ex2;

public class UserRepository {

	private User[] db = new User[100];
	private int position = 0;
	
	public void insert(User user) {
		db[position] = user;
		position++;
		
	}
	
	public User getUserById(String UserId) {
		
		for(int i =0; i<position; i++) {
			User user = db[i];
			if(user.getId().equals(UserId)) {
				return user;
			}
		}
		return null;
	}
}

package org.coursera.ita;

public class AchievementStorageFactory {
	static MemoryAchievementStorage as = new MemoryAchievementStorage();
	public static AchievementStorage getAchievementStorage() {
		if (as == null) {
			return new MemoryAchievementStorage();
		}else {
			return (AchievementStorage) as;
		}
	}
}

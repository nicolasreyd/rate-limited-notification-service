package domain;

import java.time.LocalDateTime;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import lombok.Getter;

@Getter
public class User {
  private String id;
  private SortedSet<LocalDateTime> actionsRecords = new ConcurrentSkipListSet<>();

  public User(String userId) {
    this.id = userId;
  }

  public void addRecord(LocalDateTime recordTime) {
    actionsRecords.add(recordTime);
  }

  public void removeRecord(LocalDateTime recordTime) {
    actionsRecords.remove(recordTime);
  }

  public Integer getActionsRecordsSize() {
    return actionsRecords.size();
  }
}

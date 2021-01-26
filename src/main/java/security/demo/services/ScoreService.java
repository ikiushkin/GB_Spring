package security.demo.services;
import security.demo.entities.Score;
import security.demo.repositories.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import security.demo.entities.Score;
import security.demo.repositories.ScoreRepository;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;

    public void save(Score score, int i) {
        if (i > 0 && score.getScore() < 100) {
            score.setScore(score.getScore() + i);
            scoreRepository.save(score);
        } else if (i < 0 && score.getScore() > 0) {
            score.setScore(score.getScore() + i);
            scoreRepository.save(score);
        }
    }
}

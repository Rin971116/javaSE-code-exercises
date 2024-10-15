package grammar._08_sealed;

/**
 * ClassName:
 * Description:     密封類
 *                  繼承 的權限修飾 使用 sealed ... permits
 *                      格式: sealed class Xxx permits Yyy,Zzz ， 這樣代表只有 Yyy類、Zzz類 為可以繼承 Xxx類
 *                      規則: 繼承的類必須 有以下其中一種修飾:
 *                                                          1. final 代表不能被任何類繼承，最後一代
 *                                                          2. sealed ... permits 這代表繼續使用 有條件的繼承
 *                                                          3. non_sealed 這代表無限制，可以被任何類再繼承
 * @Author Rin
 * @Create 2024/7/12 上午 02:43
 * @Version 1.0
 */
public sealed class SealedTest permits Student,Teather,Engineer{
}
final class Student extends SealedTest {}
sealed class Teather extends SealedTest permits SeniorTeacher{}
non-sealed class Engineer extends SealedTest {}

final class SeniorTeacher extends Teather {}
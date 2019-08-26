package algorithms.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ['5','3','.','.','7','.','.','.','.'],
 * ['6','.','.','1','9','5','.','.','.'],
 * ['.','9','8','.','.','.','.','6','.'],
 * ['8','.','.','.','6','.','.','.','3'],
 * ['4','.','.','8','.','3','.','.','1'],
 * ['7','.','.','.','2','.','.','.','6'],
 * ['.','6','.','.','.','.','2','8','.'],
 * ['.','.','.','4','1','9','.','.','5'],
 * ['.','.','.','.','8','.','.','7','9']
 * ]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * [
 * ['8','3','.','.','7','.','.','.','.'],
 * ['6','.','.','1','9','5','.','.','.'],
 * ['.','9','8','.','.','.','.','6','.'],
 * ['8','.','.','.','6','.','.','.','3'],
 * ['4','.','.','8','.','3','.','.','1'],
 * ['7','.','.','.','2','.','.','.','6'],
 * ['.','6','.','.','.','.','2','8','.'],
 * ['.','.','.','4','1','9','.','.','5'],
 * ['.','.','.','.','8','.','.','7','9']
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 *
 * @author 李重辰
 * @date 2019/8/23 11:25
 */
public class IsValidSudoku {
  public static void main(String[] args) {
    char[][] board = {
        {
            '5', '3', '.', '.', '7', '.', '.', '.', '.'
        },
        {
            '6', '.', '5', '1', '9', '5', '.', '.', '.'
        },
        {
            '.', '9', '8', '.', '.', '.', '.', '6', '.'
        },
        {
            '8', '.', '.', '.', '6', '.', '.', '.', '3'
        },
        {
            '4', '.', '.', '8', '.', '3', '.', '.', '1'
        },
        {
            '7', '.', '.', '.', '2', '.', '.', '.', '6'
        },
        {
            '.', '6', '.', '.', '.', '.', '2', '8', '.'
        },
        {
            '.', '.', '.', '4', '1', '9', '.', '.', '5'
        },
        {
            '.', '.', '.', '.', '8', '.', '.', '7', '9'
        }
    };

    boolean solution = new IsValidSudoku().solution(board);
    System.out.println(solution);
  }

  /**
   * 先判断行，再判断列，再判断小方块。
   * 建立一个Map记录数字出现的次数
   *
   * @param board 需要检测的数组
   * @return 有效为true，无效为false
   */
  private boolean solution(char[][] board) {
    for (int j = 0; j < 9; j++) {
      List<Character> listRow = new ArrayList<>(16);
      List<Character> listColumn = new ArrayList<>(16);
      for (int i = 0; i < 9; i++) {
        // 判断某一行中是否存在相同数字
        char tempRow = board[j][i];
        if (listRow.contains(tempRow) && tempRow != '.') {
          return false;
        } else {
          listRow.add(tempRow);
        }
        // 判断某一列中是否存在相同数字
        char tempColumn = board[i][j];
        if (listColumn.contains(tempColumn) && tempColumn != '.') {
          return false;
        } else {
          listColumn.add(tempColumn);
        }
      }
    }

    for (int rowEnd = 2; rowEnd < 9; rowEnd = rowEnd + 3) {
      for (int columnEnd = 2; columnEnd < 9; columnEnd = columnEnd + 3) {
        List<Character> listCube = new ArrayList<>(16);
        for (int row = rowEnd - 2; row <= rowEnd; row++) {
          for (int column = columnEnd - 2; column <= columnEnd; column++) {
            char tempRow = board[row][column];
            if (listCube.contains(tempRow) && tempRow != '.') {
              return false;
            } else {
              listCube.add(tempRow);
            }
          }
        }
      }
    }
    return true;
  }
}

#include <iostream>
#include <vector>

using namespace std;

bool ans;
pair<int,int> getEmptyCell(vector<vector<char>>& board){
  for(int i =0; i<9; i++){
    for(int j=0; j<9; j++){
      if(board[i][j] == '.') return {i,j};
    }
  }
  // FLAG that will tell there is no empty cell.
  return {10, 10};
}

bool isSafe(vector<vector<char>>& board, pair<int, int> cell, int i){
  char val = i+'0';

  // check same row
  for(int i=0; i<9;i++){
    if(board[cell.first][i] == val) return false;
  }

  // check column
  for(int i=0; i<9;i++){
    if(board[i][cell.second] == val) return false;
  }

  // check 3*3 box
  int startRowofBox = (cell.first / 3) * 3  ;
  int startColofBox = (cell.second / 3) * 3 ;
  for(int i = startRowofBox; i<startRowofBox+3; i++ ){
    for(int j = startColofBox; j<startColofBox+3; j++ )
    {
      if(board[i][j] == val) return false;
    }
  }
  return true;
}

void sudokuSolver(vector<vector<char>>& board){
  if(ans == true) return; // to stop backtrack after getting answer
  pair<int, int> emptyCell = getEmptyCell(board);
  if(emptyCell.first == 10){
    ans = true;
    return;
  }

  for(int i=1; i<=9; i++){
    if(isSafe(board, emptyCell, i)){
      board[emptyCell.first][emptyCell.second] = i + '0';
      sudokuSolver(board);
      board[emptyCell.first][emptyCell.second] = '.';
    }
  }

  return;
}

bool sudokuSolve( const vector<vector<char>>& board ){
  ans = false;
  vector<vector<char>> sudoku(board.begin(), board.end());
  sudokuSolver(sudoku);
  return ans;
}

int main() {
  return 0;
}
N = 8 -- board size

-- check whether position is free from attacks
function isPlaceOk( a, n, c )
  for i = 1, n - 1 do -- for every queen already placed
    if( a[i] == c ) or -- same column?
      ( a[i] - i == c - n ) or -- same diagonal?
      ( a[i] + i == c + n ) then -- same diagonal?
      return false -- place can be attacked
    end
  end
  return true
end

-- print a board
function printSolution(a)
  for i = 1, N do -- for each row
    for j = 1, N do -- for each column
      -- write X or - with a space
      io.write( a[i] == j and "X" or "-", " " );
    end
    io.write( "\n" )
  end
  io.write( "\n" )
end

-- add to board a all queens from n to N
function addQueen( a, n )
  if n >= N then
    printSolution(a)
    os.exit()
  else
    for c = 1, N do
      if isPlaceOk( a, n, c ) then
        a[n] = c -- place n-th queen at column c
        addQueen(a, n + 1)
      end
    end
  end
end

addQueen({}, 1)

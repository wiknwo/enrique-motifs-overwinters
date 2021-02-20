# Challenge 1: I love words, not binary
#   
#  Given a binary matrix, and a string of letters, replace all 1's in the matrix from 
#  left to right with the letters of the string. Once the letters have been formed into
#  the shape of the matrix, print the matrix, replacing all 0's with dots.

# Getting user input
bin_matrix = gets.split(" ")
str = gets.chomp # Darn ruby
index = 0

# Replacing 1's with str chars and 0's with '.'
bin_matrix.length.times do |i|
  if bin_matrix[i].eql? '1'
    bin_matrix[i] = str[index]
    index = (index + 1) % str.length
  elsif bin_matrix[i].eql? '0'
    bin_matrix[i] = '.'
  end
end

# Printing binary matrix
bin_matrix.length.times do |i|
  if(i % Math.sqrt(bin_matrix.length) == 0) then puts "" end
  print(bin_matrix[i].to_s)
  STDOUT.flush
end

# https://stackoverflow.com/questions/8723120/how-to-print-something-without-a-new-line-in-ruby
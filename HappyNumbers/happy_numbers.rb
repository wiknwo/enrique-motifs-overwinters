# A happy number is defined by the following process: Starting with any positive integer, replace the 
# number by the sum of the squares of its digits in base-ten, and repeat the process until the 
# number either equals 1 (where it will stay), or it loops endlessly in a cycle that does not include 1. 
# Those numbers for which this process ends in 1 are happy numbers, while those that do not end in 1 are 
# unhappy numbers (or sad numbers).

# Function to take number as input then return
# the sum of the squares of its digits.
def sum_squares_digits(digits)
    digits.split("").inject(0) {|sum, digit| sum + digit.to_i**2} # Split used to convert string to array of chars to use inject
end    

# Function to check if a number is a Happy Number
def is_happy_number(num)
    sequence = []
    while !sequence.include?(num)
        sequence << num
        num = sum_squares_digits(num.to_s)
        return true if num == 1
    end
    false
end 
   
# Getting user input
num = gets.chomp
puts "#{is_happy_number(num)}"




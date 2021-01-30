# Script to encode decimal digits using binary coded decimal(BCD)

# Function to convert decimal string to BCD string
def bcd(digits)
    codes = {'0' => '0000', '1' => '0001', '2' => '0010',
             '3' => '0011', '4' => '0100', '5' => '0101',
             '6' => '0110', '7' => '0111', '8' => '1000',
             '9' => '1001'}

    bcdstr = []         
    digits.each_char{|digit| bcdstr << codes[digit]}
    bcdstr.join("_")
end

# Main script
puts 'Enter decimal value'
decimal = gets.chomp
puts bcd(decimal)
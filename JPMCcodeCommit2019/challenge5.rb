# Country codes
country_codes = ["BE", "IE", "FR", "DE", "GR", "RO"]

# Getting user input
trade_order = gets.chomp.split("")
shift = gets.to_i

# Encrypting trading order to IBAN
iban = ""
trade_order.each_with_index do |char, index|
  iban += (char.ord + shift).to_s # ascii(char) = char.ord
  if index % 2 == 1 then iban += " " end
end

# Select country code
tmp = country_codes[rand(country_codes.length)]

# Concatenate 2-digit validation onto country code with ws char
tmp = tmp + (tmp.ord % 100).to_s + " "
iban = tmp + iban
puts iban
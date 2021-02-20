def decryptDEV(str, args)
  # base cases
  if str == ""
    args

  elsif str[0, 2] == "()"
    args << 1
    str.sub!("()", "")
    decryptDEV(str, args)

  elsif str[0, 2] == "[]"
    args << 2
    str.sub!("[]", "")
    decryptDEV(str, args)

  elsif str[0, 2] == "<>"
    args << 3
    str.sub!("<>", "")
    decryptDEV(str, args)

  # inductive steps
  else
    new_args = []
    if str.start_with?(")")
      str.sub!(str[0], "")
      new_args << args.max
      decryptDEV(str, new_args)

    elsif str.start_with?("]")
      str.sub!(str[0], "")
      new_args << args.sum
      decryptDEV(str, new_args)

    elsif str.start_with?(">")
      str.sub!(str[0], "")
      new_args << 2 * (1 + args.sum)
      decryptDEV(str, new_args)

    else
      str.sub!(str[0], "")
      decryptDEV(str, args)
    end
  end
end

# Getting user input
encryptedDEV = gets.chomp
args = []
puts decryptDEV(encryptedDEV, args)

# https://www.dotnetperls.com/sub-ruby
import tkinter as tk
import tkinter.messagebox as msgBox
import string_palindrome

class initialize_app(tk.Frame):
    def __init__(self, parent, *args, **kwargs):
        self.font = ("Helvetica", 12)
        tk.Frame.__init__(self, parent, *args, **kwargs)
        tk.Frame.pack(self)
        tk.Label(self, text="String to check: ", font=self.font).grid(row = 0)
        self.entry = tk.Entry(self, font=self.font)
        self.entry.grid(row=0, column=1)
        tk.Button(self, text='OK', command=self.display_results,
                  font=self.font).grid(row=3, column=0, pady=6)
        tk.Button(self, text='Quit', command=parent.destroy,
                  font=self.font).grid(row=3, column=1, pady=6)
        parent.bind("<Return>", self.callback)

    def callback(self, event):
        self.display_results()

    def display_results(self):
        is_palindrome = string_palindrome.palindrome(self.entry.get())
        if (is_palindrome):
            msgBox.showinfo('Answer', '{} is a palindrome.'.
                            format(self.entry.get()))
        else:
            msgBox.showinfo('Answer', '{} is not a palindrome.'.
                            format(self.entry.get()))
        self.entry.delete(0, tk.END)

if __name__ == '__main__':
    root = tk.Tk()
    root.wm_title("CheckStringPalindrome")
    initialize_app(root)
    root.mainloop()

import tkinter as tk
import tkinter.messagebox as msgBox
import find_fifth_char

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
        fifth_char = find_fifth_char.find_fifth_char(self.entry.get())
        if fifth_char == None:
            msgBox.showinfo('Answer', 'String length is less than 5.')
        else:
            msgBox.showinfo('Answer', "The fifth char is '{}'.".
                            format(fifth_char))
        self.entry.delete(0, tk.END)

if __name__ == '__main__':
    root = tk.Tk()
    root.wm_title("FindFifthChar")
    initialize_app(root)
    root.mainloop()

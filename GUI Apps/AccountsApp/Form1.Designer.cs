namespace AccountsApp
{
    partial class Accounts
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.header = new System.Windows.Forms.Label();
            this.accNumlbl = new System.Windows.Forms.Label();
            this.cNamelbl = new System.Windows.Forms.Label();
            this.ballbl = new System.Windows.Forms.Label();
            this.limitlbl = new System.Windows.Forms.Label();
            this.interestlbl = new System.Windows.Forms.Label();
            this.fileSystemWatcher1 = new System.IO.FileSystemWatcher();
            this.accNumBox = new System.Windows.Forms.TextBox();
            this.cNameBox = new System.Windows.Forms.TextBox();
            this.balBox = new System.Windows.Forms.TextBox();
            this.limitBox = new System.Windows.Forms.TextBox();
            this.interestBox = new System.Windows.Forms.TextBox();
            this.Header2 = new System.Windows.Forms.Label();
            this.checkingBut = new System.Windows.Forms.RadioButton();
            this.savingBut = new System.Windows.Forms.RadioButton();
            this.createAccbtn = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.accNumSearchlbl = new System.Windows.Forms.Label();
            this.accNumSearchBox = new System.Windows.Forms.TextBox();
            this.accSearchbtn = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.fileSystemWatcher1)).BeginInit();
            this.SuspendLayout();
            // 
            // header
            // 
            this.header.AutoSize = true;
            this.header.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.header.Location = new System.Drawing.Point(12, 9);
            this.header.Name = "header";
            this.header.Size = new System.Drawing.Size(136, 20);
            this.header.TabIndex = 0;
            this.header.Text = "Account Details";
            // 
            // accNumlbl
            // 
            this.accNumlbl.AutoSize = true;
            this.accNumlbl.Font = new System.Drawing.Font("Microsoft Uighur", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.accNumlbl.Location = new System.Drawing.Point(13, 62);
            this.accNumlbl.Name = "accNumlbl";
            this.accNumlbl.Size = new System.Drawing.Size(148, 31);
            this.accNumlbl.TabIndex = 1;
            this.accNumlbl.Text = "Account Number: ";
            // 
            // cNamelbl
            // 
            this.cNamelbl.AutoSize = true;
            this.cNamelbl.Font = new System.Drawing.Font("Microsoft Uighur", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cNamelbl.Location = new System.Drawing.Point(13, 117);
            this.cNamelbl.Name = "cNamelbl";
            this.cNamelbl.Size = new System.Drawing.Size(111, 31);
            this.cNamelbl.TabIndex = 2;
            this.cNamelbl.Text = "Client Name:";
            // 
            // ballbl
            // 
            this.ballbl.AutoSize = true;
            this.ballbl.Font = new System.Drawing.Font("Microsoft Uighur", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ballbl.Location = new System.Drawing.Point(13, 175);
            this.ballbl.Name = "ballbl";
            this.ballbl.Size = new System.Drawing.Size(79, 31);
            this.ballbl.TabIndex = 3;
            this.ballbl.Text = "Balance: ";
            // 
            // limitlbl
            // 
            this.limitlbl.AutoSize = true;
            this.limitlbl.Font = new System.Drawing.Font("Microsoft Uighur", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.limitlbl.Location = new System.Drawing.Point(10, 234);
            this.limitlbl.Name = "limitlbl";
            this.limitlbl.Size = new System.Drawing.Size(184, 31);
            this.limitlbl.TabIndex = 4;
            this.limitlbl.Text = "Daily Withdraw Limit: ";
            // 
            // interestlbl
            // 
            this.interestlbl.AutoSize = true;
            this.interestlbl.Font = new System.Drawing.Font("Microsoft Uighur", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.interestlbl.Location = new System.Drawing.Point(13, 293);
            this.interestlbl.Name = "interestlbl";
            this.interestlbl.Size = new System.Drawing.Size(116, 31);
            this.interestlbl.TabIndex = 5;
            this.interestlbl.Text = "Interest Rate: ";
            // 
            // fileSystemWatcher1
            // 
            this.fileSystemWatcher1.EnableRaisingEvents = true;
            this.fileSystemWatcher1.SynchronizingObject = this;
            // 
            // accNumBox
            // 
            this.accNumBox.Location = new System.Drawing.Point(220, 72);
            this.accNumBox.Name = "accNumBox";
            this.accNumBox.Size = new System.Drawing.Size(163, 20);
            this.accNumBox.TabIndex = 6;
            // 
            // cNameBox
            // 
            this.cNameBox.Location = new System.Drawing.Point(220, 123);
            this.cNameBox.Name = "cNameBox";
            this.cNameBox.Size = new System.Drawing.Size(163, 20);
            this.cNameBox.TabIndex = 7;
            // 
            // balBox
            // 
            this.balBox.Location = new System.Drawing.Point(220, 175);
            this.balBox.Name = "balBox";
            this.balBox.Size = new System.Drawing.Size(163, 20);
            this.balBox.TabIndex = 8;
            // 
            // limitBox
            // 
            this.limitBox.Location = new System.Drawing.Point(220, 234);
            this.limitBox.Name = "limitBox";
            this.limitBox.Size = new System.Drawing.Size(163, 20);
            this.limitBox.TabIndex = 9;
            // 
            // interestBox
            // 
            this.interestBox.Location = new System.Drawing.Point(220, 293);
            this.interestBox.Name = "interestBox";
            this.interestBox.Size = new System.Drawing.Size(163, 20);
            this.interestBox.TabIndex = 10;
            // 
            // Header2
            // 
            this.Header2.AutoSize = true;
            this.Header2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Header2.Location = new System.Drawing.Point(105, 347);
            this.Header2.Name = "Header2";
            this.Header2.Size = new System.Drawing.Size(118, 20);
            this.Header2.TabIndex = 11;
            this.Header2.Text = "Account Type";
            // 
            // checkingBut
            // 
            this.checkingBut.AutoSize = true;
            this.checkingBut.Location = new System.Drawing.Point(78, 391);
            this.checkingBut.Name = "checkingBut";
            this.checkingBut.Size = new System.Drawing.Size(70, 17);
            this.checkingBut.TabIndex = 12;
            this.checkingBut.TabStop = true;
            this.checkingBut.Text = "Checking";
            this.checkingBut.UseVisualStyleBackColor = true;
            this.checkingBut.CheckedChanged += new System.EventHandler(this.checkingBut_CheckedChanged);
            // 
            // savingBut
            // 
            this.savingBut.AutoSize = true;
            this.savingBut.Location = new System.Drawing.Point(185, 391);
            this.savingBut.Name = "savingBut";
            this.savingBut.Size = new System.Drawing.Size(63, 17);
            this.savingBut.TabIndex = 13;
            this.savingBut.TabStop = true;
            this.savingBut.Text = "Savings";
            this.savingBut.UseVisualStyleBackColor = true;
            this.savingBut.CheckedChanged += new System.EventHandler(this.savingBut_CheckedChanged);
            // 
            // createAccbtn
            // 
            this.createAccbtn.Font = new System.Drawing.Font("Microsoft Uighur", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.createAccbtn.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.createAccbtn.Location = new System.Drawing.Point(508, 347);
            this.createAccbtn.Name = "createAccbtn";
            this.createAccbtn.Size = new System.Drawing.Size(190, 61);
            this.createAccbtn.TabIndex = 14;
            this.createAccbtn.Text = "Create Account";
            this.createAccbtn.UseVisualStyleBackColor = true;
            this.createAccbtn.Click += new System.EventHandler(this.createAccbtn_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(531, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(137, 20);
            this.label1.TabIndex = 15;
            this.label1.Text = "Search Account";
            // 
            // accNumSearchlbl
            // 
            this.accNumSearchlbl.AutoSize = true;
            this.accNumSearchlbl.Font = new System.Drawing.Font("Microsoft Uighur", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.accNumSearchlbl.Location = new System.Drawing.Point(529, 61);
            this.accNumSearchlbl.Name = "accNumSearchlbl";
            this.accNumSearchlbl.Size = new System.Drawing.Size(148, 31);
            this.accNumSearchlbl.TabIndex = 16;
            this.accNumSearchlbl.Text = "Account Number: ";
            // 
            // accNumSearchBox
            // 
            this.accNumSearchBox.Location = new System.Drawing.Point(508, 96);
            this.accNumSearchBox.Name = "accNumSearchBox";
            this.accNumSearchBox.Size = new System.Drawing.Size(190, 20);
            this.accNumSearchBox.TabIndex = 17;
            // 
            // accSearchbtn
            // 
            this.accSearchbtn.Font = new System.Drawing.Font("Microsoft Uighur", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.accSearchbtn.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.accSearchbtn.Location = new System.Drawing.Point(508, 123);
            this.accSearchbtn.Name = "accSearchbtn";
            this.accSearchbtn.Size = new System.Drawing.Size(190, 57);
            this.accSearchbtn.TabIndex = 18;
            this.accSearchbtn.Text = "Find Account";
            this.accSearchbtn.UseVisualStyleBackColor = true;
            this.accSearchbtn.Click += new System.EventHandler(this.accSearchbtn_Click);
            // 
            // Accounts
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.ClientSize = new System.Drawing.Size(726, 450);
            this.Controls.Add(this.accSearchbtn);
            this.Controls.Add(this.accNumSearchBox);
            this.Controls.Add(this.accNumSearchlbl);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.createAccbtn);
            this.Controls.Add(this.savingBut);
            this.Controls.Add(this.checkingBut);
            this.Controls.Add(this.Header2);
            this.Controls.Add(this.interestBox);
            this.Controls.Add(this.limitBox);
            this.Controls.Add(this.balBox);
            this.Controls.Add(this.cNameBox);
            this.Controls.Add(this.accNumBox);
            this.Controls.Add(this.interestlbl);
            this.Controls.Add(this.limitlbl);
            this.Controls.Add(this.ballbl);
            this.Controls.Add(this.cNamelbl);
            this.Controls.Add(this.accNumlbl);
            this.Controls.Add(this.header);
            this.Name = "Accounts";
            this.Text = "Accounts";
            this.Load += new System.EventHandler(this.Accounts_Load);
            ((System.ComponentModel.ISupportInitialize)(this.fileSystemWatcher1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label header;
        private System.Windows.Forms.Label accNumlbl;
        private System.Windows.Forms.Label cNamelbl;
        private System.Windows.Forms.Label ballbl;
        private System.Windows.Forms.Label limitlbl;
        private System.Windows.Forms.Label interestlbl;
        private System.IO.FileSystemWatcher fileSystemWatcher1;
        private System.Windows.Forms.TextBox accNumBox;
        private System.Windows.Forms.TextBox limitBox;
        private System.Windows.Forms.TextBox balBox;
        private System.Windows.Forms.TextBox cNameBox;
        private System.Windows.Forms.TextBox interestBox;
        private System.Windows.Forms.RadioButton savingBut;
        private System.Windows.Forms.RadioButton checkingBut;
        private System.Windows.Forms.Label Header2;
        private System.Windows.Forms.Button createAccbtn;
        private System.Windows.Forms.Button accSearchbtn;
        private System.Windows.Forms.TextBox accNumSearchBox;
        private System.Windows.Forms.Label accNumSearchlbl;
        private System.Windows.Forms.Label label1;
    }
}

